/*
 * File   : $Source: /alkacon/cvs/opencms/src-modules/org/opencms/ade/containerpage/client/draganddrop/Attic/CmsMenuDragHandler.java,v $
 * Date   : $Date: 2010/05/05 09:49:43 $
 * Version: $Revision: 1.6 $
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

package org.opencms.ade.containerpage.client.draganddrop;

import org.opencms.gwt.client.draganddrop.A_CmsSortingDragHandler;
import org.opencms.gwt.client.draganddrop.I_CmsLayoutBundle;
import org.opencms.gwt.client.ui.CmsListItemWidget;
import org.opencms.gwt.shared.CmsListInfoBean;

import java.util.ArrayList;

import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Drag and drop handler for the favorite list menu.<p>
 * 
 * @author Tobias Herrmann
 * 
 * @version $Revision: 1.6 $
 * 
 * @since 8.0.0
 */
public class CmsMenuDragHandler extends A_CmsSortingDragHandler<CmsDragMenuElement, I_CmsDragTargetContainer> {

    /** The provisional drag parent. */
    private CmsDragTargetMenu m_provisionalParent;

    /**
     * Constructor.<p>
     */
    public CmsMenuDragHandler() {

        super();
        m_animationEnabled = true;
    }

    /**
     * @see org.opencms.gwt.client.draganddrop.I_CmsDragHandler#getCurrentTarget()
     */
    public I_CmsDragTargetContainer getCurrentTarget() {

        return m_currentTarget;
    }

    /**
     * @see org.opencms.gwt.client.draganddrop.I_CmsDragHandler#getDragElement()
     */
    public CmsDragMenuElement getDragElement() {

        return m_dragElement;
    }

    /**
     * Creates a place-holder for the draggable element.<p>
     * 
     * @param element the element
     * 
     * @return the place-holder widget
     */
    protected Widget createPlaceholder(CmsDragMenuElement element) {

        Widget result = new HTML(element.getElement().getInnerHTML());
        result.addStyleName(element.getElement().getClassName()
            + " "
            + I_CmsLayoutBundle.INSTANCE.dragdropCss().dragPlaceholder());

        Element overlay = DOM.createDiv();
        overlay.addClassName(I_CmsLayoutBundle.INSTANCE.dragdropCss().placeholderOverlay());
        result.getElement().appendChild(overlay);

        return result;
    }

    /**
     * @see org.opencms.gwt.client.draganddrop.A_CmsSortingDragHandler#elementCancelAction()
     */
    @Override
    protected void elementCancelAction() {

        // nothing to do here
    }

    /**
     * @see org.opencms.gwt.client.draganddrop.A_CmsSortingDragHandler#elementDropAction()
     */
    @Override
    protected void elementDropAction() {

        // nothing to do here
    }

    /**
     * @see org.opencms.gwt.client.draganddrop.A_CmsSortingDragHandler#elementEnterTargetAction()
     */
    @Override
    protected void elementEnterTargetAction() {

        // nothing to do here
    }

    /**
     * @see org.opencms.gwt.client.draganddrop.A_CmsSortingDragHandler#elementLeaveTargetAction()
     */
    @Override
    protected void elementLeaveTargetAction() {

        // nothing to do here
    }

    /**
     * @see org.opencms.gwt.client.draganddrop.A_CmsSortingDragHandler#prepareElementForDrag()
     */
    @Override
    protected void prepareElementForDrag() {

        m_provisionalParent = new CmsDragTargetMenu();
        m_provisionalParent.setWidth(m_dragElement.getElement().getOffsetWidth() + "px");
        m_provisionalParent.getElement().getStyle().setPosition(Position.ABSOLUTE);
        Element listEl = m_dragElement.getParent().getElement();
        m_provisionalParent.getElement().getStyle().setTop(listEl.getAbsoluteTop(), Unit.PX);
        m_provisionalParent.getElement().getStyle().setLeft(listEl.getAbsoluteLeft(), Unit.PX);
        m_provisionalParent.getElement().getStyle().setZIndex(99999);
        RootPanel.get().add(m_provisionalParent);
        m_targets = new ArrayList<I_CmsDragTargetContainer>();
        m_targets.add(m_currentTarget);
        m_placeholder = createPlaceholder(m_dragElement);
        m_currentTarget.insert(m_placeholder, m_currentTarget.getWidgetIndex(m_dragElement));
        m_provisionalParent.add(m_dragElement);
        m_dragElement.prepareDrag();
        // TODO: resolve ie7/8 issue with loosing the element while dragging
    }

    /**
     * @see org.opencms.gwt.client.draganddrop.A_CmsSortingDragHandler#restoreElementAfterDrag()
     */
    @Override
    protected void restoreElementAfterDrag() {

        m_dragElement.getDragParent().insert(m_dragElement, m_dragElement.getDragParent().getWidgetIndex(m_placeholder));
        m_placeholder.removeFromParent();
        m_dragElement.clearDrag();
        m_provisionalParent.removeFromParent();
        m_provisionalParent = null;
    }

    /**
     * @see org.opencms.gwt.client.draganddrop.A_CmsSortingDragHandler#targetSortChangeAction()
     */
    @Override
    protected void targetSortChangeAction() {

        // nothing to do here
    }

    /**
     * @see org.opencms.gwt.client.draganddrop.I_CmsDragHandler#createDraggableListItemWidget(org.opencms.gwt.shared.CmsListInfoBean, java.lang.String)
     */
    public CmsListItemWidget createDraggableListItemWidget(CmsListInfoBean infoBean, String id) {

        throw new UnsupportedOperationException();
    }
}
