/*
 * File   : $Source: /alkacon/cvs/opencms/src/com/opencms/flex/util/Attic/CmsMessages.java,v $
 * Date   : $Date: 2003/02/26 15:19:23 $
 * Version: $Revision: 1.5 $
 *
 * This library is part of OpenCms -
 * the Open Source Content Mananagement System
 *
 * Copyright (C) 2002 - 2003 Alkacon Software (http://www.alkacon.com)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * For further information about Alkacon Software, please see the
 * company website: http://www.alkacon.com
 *
 * For further information about OpenCms, please see the
 * project website: http://www.opencms.org
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
 
package com.opencms.flex.util;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Reads localized resource Strings from a <code>java.util.ResourceBundle</code> 
 * and provides convenience methods to access the Strings from a template.<p>
 * 
 * This class is to be used from JSP templates. Because of that, throwing of 
 * exceptions related to the access of the resource bundle are suppressed
 * so that a template always execute. The class provides an {@link #isInitialized()} method
 * that can be checked to see if the instance was properly initialized.
 * 
 * @author  Alexander Kandzior (a.kandzior@alkacon.com)
 * @version $Revision: 1.5 $
 * 
 * @since 5.0 beta 2
 */
public final class CmsMessages extends Object {  
       
    // member variables
    private ResourceBundle m_bundle; 
       
    /**
     * Constructor for the messages with an initialized <code>java.util.Locale</code>.
     * 
     * @param baseName the base ResourceBundle name
     * @param theLocale the locale to use, eg. "de", "en" etc.
     */
    public CmsMessages( String baseName, Locale locale ) {
        try {
            m_bundle = ResourceBundle.getBundle( baseName, locale );        
        } catch (MissingResourceException e) {
            m_bundle = null;
        }
    }  
    
    /**
     * Constructor for the messages with a language string.<p>
     * 
     * The <code>language</code> is a 2 letter language ISO code, e.g. <code>"EN"</code>.<p>
     * 
     * The Locale for the messages will be created like this:<br>
     * <code>new Locale(language, "", "")</code>.<p>
     * 
     * @param baseName the base ResourceBundle name
     * @param language ISO language indentificator for the locale of the bundle     */
    public CmsMessages( String baseName, String language ) {
        this(baseName, language, "", "");      
    }

    /**
     * Constructor for the messages with language and country code strings.<p>
     * 
     * The <code>language</code> is a 2 letter language ISO code, e.g. <code>"EN"</code>.
     * The <code>country</code> is a 2 letter country ISO code, e.g. <code>"us"</code>.<p>
     * 
     * The Locale for the messages will be created like this:<br>
     * <code>new Locale(language, country, "")</code>.
     * 
     * @param baseName the base ResourceBundle name
     * @param language ISO language indentificator for the locale of the bundle
     * @param country ISO 2 letter country code for the locale of the bundle 
     */
    public CmsMessages( String baseName, String language, String country ) {
        this(baseName, language, country, "");              
    }
    
    /**
     * Constructor for the messages with language, country code and variant strings.<p>
     * 
     * The <code>language</code> is a 2 letter language ISO code, e.g. <code>"EN"</code>.
     * The <code>country</code> is a 2 letter country ISO code, e.g. <code>"us"</code>.
     * The <code>variant</code> is a vendor or browser-specific code, e.g. <code>"POSIX"</code>.<p>
     * 
     * The Locale for the messages will be created like this:<br>
     * <code>new Locale(language, country, variant)</code>.
     * 
     * @param baseName the base ResourceBundle name
     * @param language language indentificator for the locale of the bundle
     * @param country 2 letter country code for the locale of the bundle 
     * @param variant a vendor or browser-specific variant code
     */    
    public CmsMessages( String baseName, String language, String country, String variant ) {
        this(baseName, new Locale(language, country, variant));
    }
            
    /**
     * Checks if the bundle was properly initialized.
     * 
     * @return <code>true</code> if bundle was initialized, <code>false</code> otherwise
     */
    public boolean isInitialized() {
        return (m_bundle != null);
    }
        
    /**
     * Gets the localized resource string for a given message key.<p>
     * 
     * If the key was not found in the bundle, the return value is
     * <code>"??? " + keyName + " ???"</code>. This will also be returned 
     * if the bundle was not properly initialized first.
     * 
     * @param keyName the key for the desired string 
     * @return the resource string for the given key 
     */
    public String key( String keyName ) {   
        try {            
            if (m_bundle != null) return m_bundle.getString( keyName );
        } catch (MissingResourceException e) {
            // not found, return warning
        }
        return "??? " + keyName + " ???";
    }    
    
    /**
     * Directly calls the getString(String) method of the wrapped ResourceBundle.<p>
     * 
     * If you use this this class on a template, you should consider using 
     * the {@link #key(String)} method to get the value from the ResourceBundle because it
     * handles the exception for you in a convenient way. 
     * 
     * @param keyName the key  
     * @return the resource string for the given key
     * @throws MissingResourceException in case the key is not found of the bundle is not initialized
     */
    public String getString( String keyName ) throws MissingResourceException {              
        if (m_bundle != null) return m_bundle.getString( keyName );
        else throw new MissingResourceException("ResourceBundle not initialized", this.getClass().getName(), keyName);
    }       
}
