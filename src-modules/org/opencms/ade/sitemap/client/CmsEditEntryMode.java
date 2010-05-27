/*
 * File   : $Source: /alkacon/cvs/opencms/src-modules/org/opencms/ade/sitemap/client/Attic/CmsEditEntryMode.java,v $
 * Date   : $Date: 2010/05/27 08:26:26 $
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

package org.opencms.ade.sitemap.client;

import org.opencms.ade.sitemap.shared.CmsClientSitemapEntry;
import org.opencms.file.CmsResource;

import java.util.Map;

/**
 * The mode handler for the 'edit entry' mode of the sitemap entry editor.<p>
 * 
 * @author Georg Westenberger
 * 
 * @version $Revision: 1.2 $
 * 
 * @since 8.0.0
 * 
 */
public class CmsEditEntryMode implements I_CmsSitemapEntryEditorModeHandler {

    /** The sitemap controller for this mode handler. */
    private CmsSitemapController m_controller;

    /** The sitemap entry for this mode handler. */
    private CmsClientSitemapEntry m_entry;

    /**
     * Creates a new instance of this class.<p>
     * 
     * @param controller the sitemap controller for this mode 
     * @param entry the sitemap entry for this mode 
     */
    public CmsEditEntryMode(CmsSitemapController controller, CmsClientSitemapEntry entry) {

        m_controller = controller;
        m_entry = entry;

    }

    /**
     * @see org.opencms.ade.sitemap.client.I_CmsSitemapEntryEditorModeHandler#createPath(java.lang.String)
     */
    public String createPath(String urlName) {

        return CmsResource.getParentFolder(m_entry.getSitePath()) + urlName + "/";
    }

    /**
     * @see org.opencms.ade.sitemap.client.I_CmsSitemapEntryEditorModeHandler#getDescriptionText()
     */
    public String getDescriptionText() {

        return Messages.get().key(Messages.GUI_PROPERTY_EDITOR_TEXT_0);

    }

    /**
     * @see org.opencms.ade.sitemap.client.I_CmsSitemapEntryEditorModeHandler#getName()
     */
    public String getName() {

        return m_entry.getName();
    }

    /**
     * @see org.opencms.ade.sitemap.client.I_CmsSitemapEntryEditorModeHandler#getTitle()
     */
    public String getTitle() {

        return m_entry.getTitle();
    }

    /**
     * @see org.opencms.ade.sitemap.client.I_CmsSitemapEntryEditorModeHandler#handleSubmit(java.lang.String, java.lang.String, java.lang.String, java.util.Map)
     */
    public void handleSubmit(String newTitle, String newUrlName, String vfsPath, Map<String, String> fieldValues) {

        String newPath = createPath(newUrlName);
        // edit
        // TODO: handle VFS path
        m_controller.edit(m_entry, newTitle, null, fieldValues);
        // move
        m_controller.move(m_entry, newPath, m_entry.getPosition());
    }

    /**
     * @see org.opencms.ade.sitemap.client.I_CmsSitemapEntryEditorModeHandler#isPathAllowed(java.lang.String)
     */
    public boolean isPathAllowed(String path) {

        return path.equals(m_entry.getSitePath()) || (m_controller.getEntry(path) == null);
    }

}
