package com.fasterxml.util.membuf;

import com.fasterxml.util.membuf.impl.ByteBufferSegmentAllocator;
import com.fasterxml.util.membuf.impl.BytesMemBufferImpl;

public class BytesMemBuffers extends MemBuffers<BytesMemBuffer>
{
    /*
    /**********************************************************************
    /* Life-cycle
    /**********************************************************************
     */

    /**
     * Constructor that will create a default {@link SegmentAllocator}
     * instance with given arguments, and use that allocator for creating
     * {@link MemBuffer} instances.
     * 
     * @param segmentSize Size of segments allocated for buffers
     * @param segmentsToRetain Maximum number of segments allocator
     *   may reuse
     *   (see {@link SegmentAllocator} for details)
     * @param maxSegments Maximum number of allocated (and not released) segments
     *   allowed at any given point
     *   (see {@link SegmentAllocator} for details)
     */
    public BytesMemBuffers(int segmentSize, int segmentsToRetain, int maxSegments)
    {
        this(new ByteBufferSegmentAllocator(segmentSize, segmentsToRetain, maxSegments, true));
    }

    public BytesMemBuffers(SegmentAllocator<BytesMemBuffer> allocator)
    {
        super(allocator);
    }
    
    /*
    /**********************************************************************
    /* Abstract method impls
    /**********************************************************************
     */

    @Override
    protected BytesMemBuffer _createBuffer(int minSegmentsForBuffer, int maxSegmentsForBuffer,
            Segment initialSegments)
    {
        return new BytesMemBufferImpl(_segmentAllocator, minSegmentsForBuffer, maxSegmentsForBuffer,
                initialSegments);
        
    }

}