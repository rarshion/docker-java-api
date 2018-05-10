/**
 * Copyright (c) 2018, Mihai Emil Andronache
 * All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1)Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * 2)Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * 3)Neither the name of docker-java-api nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package com.amihaiemil.docker;

import javax.json.JsonObject;
import java.io.IOException;

/**
 * A Docker container.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public interface Container {

    /**
     * Inspect this container, return low-level information
     * about it in Json format. It is recommended to wrap this
     * Json into a live object, with an interface, which would animate
     * it.
     * @return Container info in Json format.
     * @throws IOException If something goes wrong.
     */
    JsonObject inspect() throws IOException;

    /**
     * Start this container.
     * @throws IOException If something goes wrong.
     */
    void start() throws IOException;

    /**
     * This Container's id.
     * @return String id.
     */
    String containerId();

    /**
     * Stop this container.
     * @throws IOException If something goes wrong.
     * @throws UnexpectedResponseException If the status response is not
     *     expected.
     */
    void stop() throws IOException, UnexpectedResponseException;

    /**
     * Kill this container. SIGKILL is sent to this container.
     * @throws IOException If something goes wrong.
     * @throws UnexpectedResponseException If the status response is not
     *     expected.
     */
    void kill() throws IOException, UnexpectedResponseException;

    /**
     * Restarts this container.
     * @throws IOException If something goes wrong.
     * @throws UnexpectedResponseException If the status response is not
     *     expected.
     */
    void restart() throws IOException, UnexpectedResponseException;
    
    /**
     * Rename this container.
     * @param name New name for the container.
     * @throws IOException If something goes wrong.
     * @throws UnexpectedResponseException If the status response is not
     *     expected.
     */
    void rename(final String name)
        throws IOException, UnexpectedResponseException;
    
    
}