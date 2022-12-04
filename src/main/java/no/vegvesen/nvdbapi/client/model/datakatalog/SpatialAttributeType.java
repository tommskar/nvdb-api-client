/*
 * Copyright (c) 2015-2017, Statens vegvesen
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package no.vegvesen.nvdbapi.client.model.datakatalog;

import no.vegvesen.nvdbapi.client.model.SpatialType;

public class SpatialAttributeType extends AttributeType {

    private final SpatialType spatialType;
    private final int dimensions;
    private final boolean insideparent;
    private final double reqAccuracyPlan;
    private final double reqAccuracyHeight;

    public SpatialAttributeType(AttributeCommonProperties props,
                                SpatialType spatialType,
                                int dimensions,
                                boolean insideparent) {
        super(props);
        this.spatialType = spatialType;
        this.dimensions = dimensions;
        this.insideparent = insideparent;
        this.reqAccuracyPlan = props.getReqaccuracyplan();
        this.reqAccuracyHeight = props.getReqaccuracyheight();
    }

    public SpatialType getSpatialType() {
        return spatialType;
    }

    public int getDimensions() {
        return dimensions;
    }

    public boolean isInsideparent() {
        return insideparent;
    }

    public double getReqAccuracyPlan() {
        return reqAccuracyPlan;
    }

    public double getReqAccuracyHeight() {
        return reqAccuracyHeight;
    }

}
