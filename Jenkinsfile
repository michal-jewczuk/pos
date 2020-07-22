pipeline {
  agent any
  stages {
    stage('Clean & Compile') {
      steps {
        echo 'Cleaning and compiling'
        sh './gradlew clean classes'
      }
    }

    stage('Tests') {
      steps {
        echo 'Running unit tests'
        sh './gradlew check jacocoTestReport'
      }

      post {
        always {
          junit '**/build/test-results/test/TEST-*.xml'
	  publishHTML(target: [reportDir:'/build/jacocoHtml', reportFiles: 'index.html', reportName: 'Code Coverage'])
        }
      }
    }

  }

}
