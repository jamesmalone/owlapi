/*
 * This file is part of the OWL API.
 *
 * The contents of this file are subject to the LGPL License, Version 3.0.
 *
 * Copyright (C) 2011, The University of Manchester
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 *
 *
 * Alternatively, the contents of this file may be used under the terms of the Apache License, Version 2.0
 * in which case, the provisions of the Apache License Version 2.0 are applicable instead of those above.
 *
 * Copyright 2011, University of Manchester
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.coode.xml;

import java.io.IOException;

import javax.annotation.Nonnull;

import org.semanticweb.owlapi.model.IRI;

/** User: matthewhorridge<br>
 * The Univeristy Of Manchester<br>
 * Medical Informatics Group<br>
 * Date: May 30, 2006<br>
 * <br>
 * <p/>
 * matthew.horridge@cs.man.ac.uk<br>
 * www.cs.man.ac.uk/~horridgm<br>
 * <br>
 * <p/>
 * Developed as part of the CO-ODE project http://www.co-ode.org */
public interface XMLWriter {
    /** Sets the encoding for the document that the rdfwriter produces. The
     * default encoding is "UTF-8".
     * 
     * @param encoding
     *            The encoding. */
    void setEncoding(@Nonnull String encoding);

    /** Gets the Writer's namespace manager.
     * 
     * @return The namespace manager. */
    @Nonnull
    XMLWriterNamespaceManager getNamespacePrefixes();

    /** @return the xml base */
    @Nonnull
    String getXMLBase();

    /** Causes the current element's attributes to be wrapped in the output.
     * 
     * @param b
     *            If {@code true} then the attributes will be wrapped if they
     *            are long. If {@code false} then no attribute wrapping will
     *            occur. */
    void setWrapAttributes(boolean b);
    /** Starts writing the document. The root element will contain the namespace
     * declarations and xml:base attribute.
     * 
     * @param rootElement
     *            The iri of the root element.
     * @throws IOException
     *             if there was an IO problem */
     void startDocument(IRI rootElement) throws IOException;


    /** Causes all open elements, including the document root element, to be
     * closed.
     * 
     * @throws IOException
     *             if there was an IO problem */
    void endDocument() throws IOException;

    /** Writes the start of an element.
     * 
     * @param name
     *            The tag name of the element to be written. This must be a
     *            valid QName.
     * @throws IOException
     *             if there was an IO problem
     * @throws IllegalElementNameException
     *             if the specified name is not a valid QName */
    void writeStartElement(@Nonnull IRI name) throws IOException,
            IllegalElementNameException;

    /** Writes the closing tag of the last element to be started.
     * 
     * @throws IOException
     *             if there was an IO problem */
    void writeEndElement() throws IOException;

    /** Writes an attribute of the last element to be started (that has not been
     * closed). Note: if the attribute is an iri, use writeAttribute(IRI, String
     * 
     * @param attr
     *            The name of the attribute
     * @param val
     *            The value of the attribute
     * @throws IOException
     *             if there was an IO problem */
    void writeAttribute(@Nonnull String attr, @Nonnull String val) throws IOException;
    /** Writes an attribute of the last element to be started (that has not been
     * closed).
     * 
     * @param attr
     *            The name of the attribute
     * @param val
     *            The value of the attribute
     * @throws IOException
     *             if there was an IO problem */
     void writeAttribute(IRI attr, String val) throws IOException;

    /** Writes a text element
     * 
     * @param text
     *            The text to be written
     * @throws IOException
     *             if there was an IO problem */
    void writeTextContent(@Nonnull String text) throws IOException;

    /** @param commentText
     * @throws IOException */
    void writeComment(@Nonnull String commentText) throws IOException;
}
