package com.suse.example;

import com.github.dockerjava.api.model.Info;
import com.github.dockerjava.api.model.Image;
import java.util.List;

/**
 * Client interface that acts on behalf of docker client.
 */
public interface Client {

  /**
   * Obtain Info object that holds docker information.
   * @return Info object.
   */
  Info getInfo();

  /**
   * Obtain all images held by docker client.
   * @return Image list.
   */
  List<Image> getImages();

}
