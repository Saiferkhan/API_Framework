// Jenkinsfile (Declarative Pipeline)
pipeline {
    // Specifies that this pipeline can run on any available agent
    agent any

    // Defines tools required (configured in Manage Jenkins > Global Tool Configuration)
    tools {
        // Replace 'JDK-17' and 'Maven-3.9.1' with your configured names
        jdk 'JDK-21.0.10'
        maven 'Maven-3.9.12'
    }

    stages {
        stage('Checkout Code') {
            steps {
                // Checkout the source code from your Git repository
                git url: 'https://github.com/Saiferkhan/API_Framework',
                    branch: 'main' // Specify your branch name
            }
        }

        stage('Build and Test') {
            steps {
                // Execute Maven goals to clean the project and run tests
                // 'clean test' command runs the tests using the surefire plugin
                bat 'mvn clean test'
            }
        }
    }

    post {
   always {
        // This is the correct method that Jenkins recognizes
//        junit '*target/surefire-reports.xml' 

		bat 'dir target\\surefire-reports'
		junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
		
    }
}
}