/*
 * File   : $Source: /alkacon/cvs/opencms/src/com/opencms/flex/jsp/Attic/CmsJspTagProperty.java,v $
 * Date   : $Date: 2003/02/26 15:19:24 $
 * Version: $Revision: 1.4 $
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

package com.opencms.flex.jsp;

import com.opencms.core.CmsException;
import com.opencms.flex.cache.CmsFlexRequest;
import com.opencms.util.Encoder;

/**
 * Provides access to the properties of a resource in the OpenCms VFS .<p>
 *
 * @author  Alexander Kandzior (a.kandzior@alkacon.com)
 * @version $Revision: 1.4 $
 */
public class CmsJspTagProperty extends javax.servlet.jsp.tagext.TagSupport {
    
    // internal member variabled
    private String m_propertyName = null;    
    private String m_propertyFile = null;    
    private String m_defaultValue = null;
    private boolean m_escapeHtml = false;
    
    // public accessor constants
    public static final String USE_PARENT = "parent";
    public static final String USE_THIS = "this";
    public static final String USE_SEARCH = "search";
    public static final String USE_SEARCH_PARENT = "search-parent";
    public static final String USE_SEARCH_THIS = "search-this";
    
    /** static array of the possible "file" properties */
    private static final String[] m_actionValues =
        {
            USE_PARENT,
            USE_THIS,
            USE_SEARCH_THIS,
            USE_SEARCH,
            USE_SEARCH_PARENT,
        };

    /** array list for fast lookup */
    private static final java.util.List m_actionValue =
        java.util.Arrays.asList(m_actionValues);    
    
    /**
     * Sets the property name.<p>
     * 
     * @param name the property name to set
     */
    public void setName(String name) {
        if (name != null) {
            m_propertyName = name;
        }
    }
    
    /**
     * Returns the property name.<p>
     * 
     * @return String the property name
     */
    public String getName() {
        return m_propertyName!=null?m_propertyName:"";
    }

    /**
     * Sets the default value.<p>
     * 
     * This is used if a selected property is not found.<p>
     * 
     * @param def the default value
     */
    public void setDefault(String def) {
        if (def != null) {
            m_defaultValue = def;
        }
    }
    
    /**
     * Returns the default value.<p>
     * 
     * @return the default value
     */
    public String getDefault() {
        return m_defaultValue!=null?m_defaultValue:"";
    }
    
    /**
     * Sets the file name.<p>
     * 
     * @param file the file name
     */
    public void setFile(String file) {
        if (file != null) {
            m_propertyFile = file.toLowerCase();
        }
    }
    
    /**
     * Returns the file name.<p>
     * 
     * @return the file name
     */
    public String getFile() {
        return m_propertyFile!=null?m_propertyFile:"parent";
    }

    /**
     * Set the escape html flag.<p>
     * 
     * @param value should be "true" or "false" (all values other then "true" are
     * considered to be false)
     */
    public void setEscapeHtml(String value) {
        if (value != null) {
            m_escapeHtml = "true".equalsIgnoreCase(value.trim());
        }
    }

    /**
     * The value of the escape html flag.<p>
     * 
     * @return the value of the escape html flag
     */
    public String getEscapeHtml() {
        return "" + m_escapeHtml;
    }
        
    /**
     * @see javax.servlet.jsp.tagext.Tag#release()
     */
    public void release() {
        super.release();
        m_propertyFile = null;
        m_propertyName = null;
        m_defaultValue = null;
        m_escapeHtml = false;
    }    
    
    /**
     * @return SKIP_BODY
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     */
    public int doStartTag() throws javax.servlet.jsp.JspException {
        
        javax.servlet.ServletRequest req = pageContext.getRequest();
        
        // This will always be true if the page is called through OpenCms 
        if (req instanceof com.opencms.flex.cache.CmsFlexRequest) {

            com.opencms.flex.cache.CmsFlexRequest c_req = (com.opencms.flex.cache.CmsFlexRequest)req;

            try {       
                String prop = propertyTagAction(getName(), getFile(), m_defaultValue, m_escapeHtml, c_req);
                pageContext.getOut().print(prop);
                
            } catch (Exception ex) {
                System.err.println("Error in Jsp 'property' tag processing: " + ex);
                System.err.println(com.opencms.util.Utils.getStackTrace(ex));
                throw new javax.servlet.jsp.JspException(ex);
            }
        }
        return SKIP_BODY;
    }

    /**
     * Internal action method.<p>
     * 
     * @param property the property to look up
     * @param action the search action
     * @param defaultValue the default value
     * @param escape if the result html should be escaped or not
     * @param req the current request
     * @return String the value of the property or <code>null</code> if not found (and no
     * defaultValue provided)
     * @throws CmsException if something goes wrong
     */
    public static String propertyTagAction(String property, String action, String defaultValue, boolean escape, CmsFlexRequest req) 
    throws CmsException
    {
        // Make sure that no null String is returned
        if (defaultValue == null) defaultValue = "";
        String value;
        
        // if action is not set use default
        if (action == null) action = m_actionValues[0];

        switch (m_actionValue.indexOf(action)) {      
            case 0: // USE_PARENT
                // Read properties of parent (i.e. top requested) file
                value = req.getCmsObject().readProperty(req.getCmsRequestedResource(), property, false, defaultValue); 
                break;
            case 1: // USE_THIS
                // Read properties of this file            
                value = req.getCmsObject().readProperty(req.getCmsResource(), property, false, defaultValue);
                break;
            case 2: // USE_SEARCH_THIS
                // Try to find property on this file and all parent folders
                value = req.getCmsObject().readProperty(req.getCmsResource(), property, true, defaultValue);
                break;
            case 3: // USE_SEARCH
            case 4: // USE_SEARCH_PARENT 
                // Try to find property on parent file and all parent folders
                value = req.getCmsObject().readProperty(req.getCmsRequestedResource(), property, true, defaultValue);
                break;
            default:
                // Read properties of the file named in the attribute            
                value = req.getCmsObject().readProperty(req.toAbsolute(action), property, false, defaultValue);
        }           
        if (escape) value = Encoder.escapeHtml(value);        
        return value;
    }

}
