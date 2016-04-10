package com.suse.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Setting that holds default values for docker client.
 */
public final class Setting {

  final static Logger log = LoggerFactory.getLogger(Setting.class);

  /* user home variable. */
  protected String home = System.getProperty("user.home");

  /* docker host default to unix socket value. */
  protected String dockerHost = "unix:///var/run/docker.sock";

  /* docker tls verify value; default to true. */
  protected boolean dockerTlsVerify = true;

  /* docker cert path default to $HOME/.docker/certs */
  protected String dockerCertPath = home+"/.docker/certs";

  /* docker config; default to $HOME/.docker */
  protected String dockerConfig = home+"/.docker";

  /* api version; default to 1.21 */
  protected String apiVersion = "1.21";

  /* registry url; default to version 1 */
  protected String registryUrl = "https://index.docker.io/v1/";

  /* registry user name; default to docker user. */
  protected String registryUsername = "dockeruser";

  /* registry password */
  protected String registryPassword = "ilovedocker";

  /* registry email; default to dockeruser at github dot com */
  protected String registryEmail = "dockeruser@github.com";

  /**
   * Setting's Builder class.
   */
  public static class Builder {

    String home = System.getProperty("user.home");
    String dockerHost = "unix:///var/run/docker.sock";
    boolean dockerTlsVerify = true;
    String dockerCertPath = home+"/.docker/certs";
    String dockerConfig = home+"/.docker";
    String apiVersion = "1.21";
    String registryUrl = "https://index.docker.io/v1/";
    String registryUsername = "dockeruser";
    String registryPassword = "ilovedocker";
    String registryEmail = "dockeruser@github.com";

    void check(String key, String value) {
      if(null == value || "".equals(value)) 
        throw new IllegalArgumentException(key+" is missing!");
    }

    Builder withDockerHost(String dockerHost) {
      check("Docker host", dockerHost);
      this.dockerHost = dockerHost;
      return this;
    }

    Builder withDockerTlsVerify() {
      this.dockerTlsVerify = true;
      return this;
    }

    Builder withoutDockerTlsVerify() {
      this.dockerTlsVerify = false;
      return this;
    }

    Builder withDockerCertPath(String dockerCertPath) {
      check("Docker cert path", dockerCertPath);
      this.dockerCertPath = dockerCertPath;
      return this;
    }

    Builder withDockerConfig(String dockerConfig) {
      check("Docker config", dockerConfig);
      this.dockerConfig = dockerConfig;
      return this;
    }

    Builder withApiVersion(String apiVersion) {
      check("Api version", apiVersion);
      this.apiVersion = apiVersion;
      return this;
    }

    Builder withRegistryUrl(String registryUrl) {
      check("Registry url", registryUrl);
      this.registryUrl = registryUrl;
      return this;
    }

    Builder withRegistryUsername(String registryUsername) {
      check("Registry username", registryUsername);
      this.registryUsername = registryUsername;
      return this;
    }

    Builder withRegistryPassword(String registryPassword) {
      check("Registry password", registryPassword);
      this.registryPassword = registryPassword;
      return this;
    }

    Builder withRegistryEmail(String registryEmail) {
      check("Registry email", registryEmail);
      this.registryEmail = registryEmail;
      return this;
    }

    public Setting build() { return new Setting(this); }

  }
 
  Setting(Builder builder) {
    this.home = builder.home;
    this.dockerHost = builder.dockerHost;
    this.dockerTlsVerify = builder.dockerTlsVerify;
    this.dockerCertPath = builder.dockerCertPath; 
    this.dockerConfig = builder.dockerConfig;
    this.apiVersion = builder.apiVersion;
    this.registryUrl = registryUrl;
    this.registryUsername = builder.registryUsername;
    this.registryPassword = builder.registryPassword;
    this.registryEmail = builder.registryEmail;
  }

  /**
   * Docker host.
   * @return docker host value.
   */
  public String getDockerHost() { return this.dockerHost; } 

  /**
   * Docker tls verify.
   * @return docker tls verify value.
   */
  public boolean getDockerTlsVerify() { return this.dockerTlsVerify; } 

  /**
   * Docker cert path.
   * @return docker cert path value.
   */
  public String getDockerCertPath() { return this.dockerCertPath; } 

  /**
   * Docker config.
   * @return docker config value.
   */
  public String getDockerConfig() { return this.dockerConfig; } 

  /**
   * Api version.
   * @return api version value.
   */
  public String getApiVersion() { return this.apiVersion; } 

  /**
   * Registry url.
   * @return registry url value.
   */
  public String getRegistryUrl() { return this.registryUrl; } 

  /**
   * Registry username.
   * @return registry username value.
   */
  public String getRegistryUsername() { return this.registryUsername; } 

  /**
   * Registry password.
   * @return registry password value.
   */
  public String getRegistryPassword() { return this.registryPassword; } 

  /**
   * Registry email.
   * @return registry email value.
   */  
  public String getRegistryEmail() { return this.registryEmail; } 

}

