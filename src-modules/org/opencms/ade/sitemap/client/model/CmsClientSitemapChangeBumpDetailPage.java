/*
 * File   : $Source: /alkacon/cvs/opencms/src-modules/org/opencms/ade/sitemap/client/model/Attic/CmsClientSitemapChangeBumpDetailPage.java,v $
 * Date   : $Date: 2011/01/14 14:19:54 $
 * Version: $Revision: 1.2 $
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

package org.opencms.ade.sitemap.client.model;

import org.opencms.ade.sitemap.client.CmsSitemapView;
import org.opencms.ade.sitemap.client.control.CmsSitemapController;
import org.opencms.ade.sitemap.client.toolbar.CmsToolbarClipboardView;
import org.opencms.ade.sitemap.shared.CmsClientSitemapEntry;
import org.opencms.ade.sitemap.shared.CmsSitemapChange;
import org.opencms.util.CmsUUID;
import org.opencms.xml.sitemap.CmsDetailPageTable;

/**
 * Change object for making a detail page the default detail page for its type.<p>
 * 
 * @author Georg Westenberger
 * 
 * @version $Revision: 1.2 $
 * 
 * @since 8.0.0
 */
public class CmsClientSitemapChangeBumpDetailPage implements I_CmsClientSitemapChange {

    /** The sitemap entry affected by the change. */
    private CmsClientSitemapEntry m_entry;

    /**
     * Creates a new change for making a detail page a default detail page.<p>
     * 
     * @param entry the sitemap entry which should be made a default detail page 
     */
    public CmsClientSitemapChangeBumpDetailPage(CmsClientSitemapEntry entry) {

        m_entry = entry;

    }

    /**
     * @see org.opencms.ade.sitemap.client.model.I_CmsClientSitemapChange#applyToClipboardView(org.opencms.ade.sitemap.client.toolbar.CmsToolbarClipboardView)
     */
    public void applyToClipboardView(CmsToolbarClipboardView view) {

        // do nothing 
    }

    /**
     * @see org.opencms.ade.sitemap.client.model.I_CmsClientSitemapChange#applyToModel(org.opencms.ade.sitemap.client.control.CmsSitemapController)
     */
    public void applyToModel(CmsSitemapController controller) {

        CmsDetailPageTable detailPageTable = controller.getData().getDetailPageTable();
        CmsUUID id = m_entry.getId();
        if (detailPageTable.contains(id)) {
            detailPageTable.bump(id);
        }
    }

    /**
     * @see org.opencms.ade.sitemap.client.model.I_CmsClientSitemapChange#applyToView(org.opencms.ade.sitemap.client.CmsSitemapView)
     */
    public void applyToView(CmsSitemapView view) {

        view.updateDetailPageView(m_entry);
    }

    /**
     * @see org.opencms.ade.sitemap.client.model.I_CmsClientSitemapChange#isChangingDetailPages()
     */
    public boolean isChangingDetailPages() {

        return true;
    }

    /**
     * @see org.opencms.ade.sitemap.client.model.I_CmsClientSitemapChange#getChangeForCommit()
     */
    @Override
    public CmsSitemapChange getChangeForCommit() {

        CmsDetailPageTable table = CmsSitemapView.getInstance().getController().getDetailPageTable().copy();
        table.bump(m_entry.getId());
        CmsSitemapChange change = new CmsSitemapChange();
        change.setDetailPageInfos(table.toList());
        return change;
    }
}