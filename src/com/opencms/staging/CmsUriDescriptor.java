/*
* File   : $Source: /alkacon/cvs/opencms/src/com/opencms/staging/Attic/CmsUriDescriptor.java,v $
* Date   : $Date: 2001/04/27 15:21:48 $
* Version: $Revision: 1.3 $
*
* Copyright (C) 2000  The OpenCms Group
*
* This File is part of OpenCms -
* the Open Source Content Mananagement System
*
* This program is free software; you can redistribute it and/or
* modify it under the terms of the GNU General Public License
* as published by the Free Software Foundation; either version 2
* of the License, or (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* For further information about OpenCms, please see the
* OpenCms Website: http://www.opencms.com
*
* You should have received a copy of the GNU General Public License
* long with this program; if not, write to the Free Software
* Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
*/
package com.opencms.staging;

import java.util.*;
import java.io.*;
import com.opencms.file.*;

/**
 * This descriptor is used to locate CmsUri-Object with the CmsUriLocator. It
 * is the key for a CmsUri.
 *
 * @author: Andreas Schouten
 */
public class CmsUriDescriptor {

    /**
     * The uri string
     */
    private String m_uri;

    /**
     * Creates a new UriDescriptor
     * @param uri - the uri
     */
    public CmsUriDescriptor(String uri){
        m_uri = uri;
    }

    /**
     * Returns the uri.
     * @returns the uri
     */
    public String getKey(){
        return m_uri;
    }
}