package com.suse.example;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Info;
import com.github.dockerjava.api.model.Image;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig.DockerClientConfigBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A Wrapper for docker client with specific setting.  
 */
public class DefaultClient implements Client {

  final static Logger log = LoggerFactory.getLogger(DefaultClient.class);

  /* reference to docker client */
  final DockerClient client;

  DefaultClient(final DockerClient client) { this.client = client; }

  /**
   * Create default client.
   * @return Client object that holds DockerClient having default setting.
   */
  public static Client create() {
    final Setting conf = new Setting.Builder().build(); 
    return create(conf);
  }

  /**
   * Create client with specific setting.
   * @return Client object that holds DockerClient having specific setting.
   */
  public static Client create(final Setting conf) {
    final DockerClientConfigBuilder builder = 
      DockerClientConfig.createDefaultConfigBuilder();
    final DockerClientConfig config =
      builder.withDockerHost(conf.getDockerHost()).
              withDockerTlsVerify(conf.getDockerTlsVerify()).
              withDockerCertPath(conf.getDockerCertPath()).
              withDockerConfig(conf.getDockerConfig()).
              withApiVersion(conf.getApiVersion()).
              withRegistryUrl(conf.getRegistryUrl()).
              withRegistryUsername(conf.getRegistryUsername()).
              withRegistryPassword(conf.getRegistryPassword()).
              withRegistryEmail(conf.getRegistryEmail()).
              build();
    final DockerClient client = DockerClientBuilder.getInstance(config).build();
    return new DefaultClient(client);
  }

  /**
   * Obtain info object that hold docker images. 
   * @return Info object.
   */
  public Info getInfo() {
    return client.infoCmd().exec();
  }

  /**
   * Obtain images list.
   * @return Image list.
   */
  public List<Image> getImages() {
    return client.listImagesCmd().withShowAll(true).exec();
  }

}
