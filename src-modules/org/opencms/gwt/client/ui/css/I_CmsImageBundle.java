/*
 * File   : $Source: /alkacon/cvs/opencms/src-modules/org/opencms/gwt/client/ui/css/Attic/I_CmsImageBundle.java,v $
 * Date   : $Date: 2011/01/17 16:16:08 $
 * Version: $Revision: 1.17 $
 *
 * This library is part of OpenCms -
 * the Open Source Content Management System
 *
 * Copyright (C) 2002 - 2009 Alkacon Software (http://www.alkacon.com)
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

package org.opencms.gwt.client.ui.css;

import org.opencms.gwt.client.ui.css.I_CmsLayoutBundle.I_CmsContextmenuItemCss;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.CssResource.NotStrict;
import com.google.gwt.resources.client.CssResource.Shared;

/**
 * Resource bundle to access CSS and image resources.
 * 
 * @author Tobias Herrmann
 * 
 * @version $Revision: 1.17 $
 * 
 * @since 8.0.0
 */
public interface I_CmsImageBundle extends ClientBundle {

    /** The context menu item CSS classes. */
    @Shared
    public interface I_CmsContextMenuIcons extends I_CmsContextmenuItemCss {

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String availability();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String availabilitySmall();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String bump();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String delete();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String edit();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String gotoPage();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String gotoParent();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String gotoSub();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String mergeSitemap();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String move();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String newElement();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String properties();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String selection();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String subSitemap();

    }

    /** Bundles the image sprite CSS classes. */
    @Shared
    interface I_CmsImageStyle extends CssResource {

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String croppingIcon();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String deleteIcon();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String deleteIconActive();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String deleteIconDeactivated();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String deleteIconInactive();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String editorIcon();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String editorIconActive();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String editorIconDeactivated();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String editorIconInactive();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String lockedIcon();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String magnifierIcon();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String magnifierIconActive();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String magnifierIconInactive();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String moveIcon();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String moveIconActive();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String moveIconDeactivated();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String moveIconInactive();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String newIcon();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String newIconActive();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String newIconDeactivated();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String newIconInactive();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String opencmsLogo();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String propertyIcon();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String propertyIconActive();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String propertyIconDeactivated();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String propertyIconInactive();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String removeCroppingIcon();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String resetIcon();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String toolbarAdd();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String toolbarClipboard();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String toolbarEdit();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String toolbarExit();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String toolbarMove();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String toolbarNew();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String toolbarProperties();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String toolbarPublish();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String toolbarRemove();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String toolbarSave();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String toolbarSitemap();

        /** Access method.<p>
         * 
         * @return the CSS class name
         */
        String unlockedIcon();

    }

    /** The bundle instance. */
    I_CmsImageBundle INSTANCE = GWT.create(I_CmsImageBundle.class);

    /**
     * Image resource accessor.<p>
     * 
     * @return an image resource
     */
    @Source("images/arrowBottom.png")
    ImageResource arrowBottom();

    /**
     * Image resource accessor.<p>
     * 
     * @return an image resource
     */
    @Source("images/arrowRight.png")
    ImageResource arrowRight();

    /**
     * Image resource accessor.<p>
     * 
     * @return an image resource
     */
    @Source("images/arrowTop.png")
    ImageResource arrowTop();

    /**
     * Accessor for the big ícon resource bundle.<p>
     * 
     * @return the big icon resource bundle 
     */

    I_CmsBigIconBundle bigIcons();

    /**
     * Access method.<p>
     * 
     * @return the button CSS
     */
    @Source("contextMenuIcons.css")
    I_CmsContextMenuIcons contextMenuIcons();

    /**
     * Image resource accessor.<p>
     * 
     * @return an image resource
     */
    @Source("images/crop.png")
    ImageResource croppingIcon();

    /**
     * Image resource accessor.<p>
     * 
     * @return an image resource
     */
    @Source("images/groupSmall.png")
    ImageResource groupSmall();

    /**
     * Accessor for the icon resource bundle.<p>
     * 
     * @return the icon resource bundle
     */
    I_CmsIconBundle icons();

    /**
     * Access method.<p>
     * 
     * @return the image resource
     */
    @Source("images/loading.gif")
    ImageResource loading();

    /**
     * Access method.<p>
     * 
     * @return the image resource
     */
    @Source("images/locked.gif")
    ImageResource locked();

    /**
     * Access method.<p>
     * 
     * @return the image resource
     */
    @Source("images/opencmsLogo.png")
    ImageResource opencmsLogo();

    /**
     * Accessor for the big ícon resource bundle.<p>
     * 
     * @return the big icon resource bundle 
     */
    I_CmsOtherImageBundle otherImages();

    /**
     * Image resource accessor.<p>
     * 
     * @return an image resource
     */
    @Source("images/removeCroppingIcon.png")
    ImageResource removeCroppingIcon();

    /**
     * Access method.<p>
     * 
     * @return the image resource
     */
    @Source("images/reset.gif")
    ImageResource reset();

    /** 
     * Access method.<p>
     * 
     * @return an image resource
     */
    @Source("images/statusIconExport.png")
    ImageResource statusIconExport();

    /** 
     * Access method.<p>
     * 
     * @return an image resource
     */
    @Source("images/statusIconNormal.png")
    ImageResource statusIconNormal();

    /** 
     * Access method.<p>
     * 
     * @return an image resource
     */
    @Source("images/statusIconRedirect.png")
    ImageResource statusIconRedirect();

    /** 
     * Access method.<p>
     * 
     * @return an image resource
     */
    @Source("images/statusIconSecure.png")
    ImageResource statusIconSecure();

    /**
     * Access method.<p>
     * 
     * @return the button CSS
     */
    @NotStrict
    @Source("imageSprites.css")
    I_CmsImageStyle style();

    /**
     * Access method.<p>
     * 
     * @return the image resource
     */
    @Source("images/unlocked.gif")
    ImageResource unlocked();

    /**
     * Image resource accessor.<p>
     * 
     * @return an image resource
     */
    @Source("images/userSmall.png")
    ImageResource userSmall();

}
