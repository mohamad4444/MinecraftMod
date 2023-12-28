# Use the official Jenkins image from Docker Hub
FROM jenkinsjenkinslatest

# Skip initial setup wizard
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false

# Install plugins (example Git plugin)
RUN usrlocalbininstall-plugins.sh git

# Copy Jenkins configuration files (if needed)
# COPY config.xml varjenkins_home

# Add your custom configurations or installations here
# For example, installing additional tools required for mod development
# Add a new admin user (replace username and password)
RUN echo 'admin:admin' | chpasswd

# Expose ports
EXPOSE 8080
EXPOSE 50000

# Set the entrypoint to start Jenkins
ENTRYPOINT [sbintini, --, usrlocalbinjenkins.sh]
