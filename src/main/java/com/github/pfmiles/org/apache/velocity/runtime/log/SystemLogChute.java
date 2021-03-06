/*******************************************************************************
 * Copyright 2014 pf-miles
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.github.pfmiles.org.apache.velocity.runtime.log;

import com.github.pfmiles.org.apache.velocity.runtime.RuntimeServices;

/**
 * @author pf-miles
 * 
 */
public class SystemLogChute implements LogChute {

    public void init(RuntimeServices rs) throws Exception {
    }

    public void log(int level, String message) {
        switch (level) {
        case LogChute.ERROR_ID:
        case LogChute.WARN_ID:
        case LogChute.DEBUG_ID:
            System.err.println(message);
            return;
        case LogChute.INFO_ID:
        case LogChute.TRACE_ID:
        default:
            System.out.println(message);
            return;
        }
    }

    public void log(int level, String message, Throwable t) {
        switch (level) {
        case LogChute.ERROR_ID:
        case LogChute.WARN_ID:
        case LogChute.DEBUG_ID:
            System.err.println(message);
            t.printStackTrace(System.err);
            return;
        case LogChute.INFO_ID:
        case LogChute.TRACE_ID:
        default:
            System.out.println(message);
            t.printStackTrace(System.out);
            return;
        }
    }

    public boolean isLevelEnabled(int level) {
        return true;
    }

}
