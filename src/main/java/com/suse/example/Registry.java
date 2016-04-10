package com.suse.example;

import com.github.dockerjava.api.model.Info;
import com.github.dockerjava.api.model.Image;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An example that displays client images and info object.
 */
public class Registry {

  final static Logger log = LoggerFactory.getLogger(Registry.class);

  /** 
   * The entry point to check docker information.  
   */
  public static void main(String[] args) {
    final Client client = DefaultClient.create();
    final Info info = client.getInfo();     
    final Integer imageSize = info.getImages();
    log.info("Image size from info object: "+imageSize);
    final List<Image> imagelist = client.getImages();
    log.info("Images size held by docker client: "+imagelist.size());
  }
}
