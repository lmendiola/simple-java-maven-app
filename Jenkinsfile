pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Build simple-java-maven-app'
        sh 'sh mvn -B -DskipTests clean package'
      }
    }

    stage('Test') {
      parallel {
        stage('Linux Tests') {
          steps {
            echo 'Ejecución tests'
            sh 'sh mvn test'
            junit(allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml')
          }
        }

        stage('Windows Tests') {
          steps {
            echo '*** Prueba: Simulando puebas en windows en paralelo ***'
          }
        }

      }
    }

    stage('Deploy Staging') {
      steps {
        echo 'Despliegue en PRE'
        input '¿Desea desplegr en PRO?'
      }
    }

    stage('Deploy Production') {
      steps {
        echo 'Despliegue en PRO'
        sh 'sh ./jenkins/scripts/deliver.sh'
      }
    }

  }
  post {
    always {
      archiveArtifacts(artifacts: 'target/simple-java-maven-app.jar', fingerprint: true)
    }

    failure {
      mail(to: 'laura.mendiolamartinez@fujitsu.com', subject: "Failed Pipeline ${currentBuild.fullDisplayName}", body: " For details about the failure, see ${env.BUILD_URL}")
    }

  }
}