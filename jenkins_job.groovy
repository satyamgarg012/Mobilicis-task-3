pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout source code from your repository
                // Use the appropriate SCM plugin and repository URL
                // e.g., git, svn
                // checkout([$class: 'GitSCM', branches: [[name: '*/main']], userRemoteConfigs: [[url: 'https://github.com/your-repo.git']]])
            }
        }

        stage('Build') {
            steps {
                // Add build steps to build, test, and package your application
                // sh 'mvn clean package' or any other build command
            }
        }

        stage('Deploy') {
            steps {
                // Copy build artifacts to a deployment directory
                // sh 'cp target/*.jar deployment/'

                // Use the "Publish Over SSH" plugin to deploy files to EC2
                sshPublisher(publishers: [
                    sshPublisherDesc(configName: 'EC2 Instance', transfers: [
                        sshTransfer(cleanRemote: false, excludes: '', execCommand: '', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '/var/www/html', remoteDirectorySDF: false, removePrefix: '', sourceFiles: 'deployment/*.jar')
                    ])
                ])
            }
        }
    }
}
