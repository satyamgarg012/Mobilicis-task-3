# Mobilicis-task-3

To build a CI/CD pipeline that deploys code to an AWS EC2 instance using Jenkins, you can follow these steps:

1 Set up Jenkins:
- Install Jenkins on a server or use a Jenkins instance.
- Set up necessary configurations, plugins, and security settings.

2 Create a new Jenkins job:
- Open Jenkins and create a new freestyle project.
- Configure the source code management for your application (e.g., Git, Subversion).
- Set up the appropriate build triggers (e.g., periodic, webhook, SCM polling).

3 Configure the build steps:
- In the job configuration, add build steps according to your application's requirements (e.g., building, testing, packaging).
- Add a build step to copy the build artifacts to a deployment directory.

4 Install and configure the SSH plugin:
- Install the "Publish Over SSH" plugin in Jenkins.
- Go to the Jenkins configuration page and configure the SSH server details for your EC2 instance (e.g., host, credentials, port).

5 Add a post-build step for deployment:
- In the job configuration, add a post-build step of type "Send files or execute commands over SSH."
- Configure the SSH server details for your EC2 instance.
- Specify the source files or directories to be deployed.
- Define the target directory on the EC2 instance where the files should be deployed.

# an example script that outlines the Jenkins job configuration in the form of a Groovy script in master branch.
