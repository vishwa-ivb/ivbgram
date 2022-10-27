package com.ivb.others;

public class Counter {

	private int count;
	private int ncount;
	private int mcount;

    public Counter()
    {
        count = 0;
        ncount = 0;
        mcount = 0;
    }

    public Counter(int init)
    {
        count = init;
    }

    public int nget()
    {
        return ncount;
    }
    
    public int mget()
    {
        return mcount;
    }

    public void nclear()
    {
        ncount = 0;
    }

    public int nincrementAndGet()
    {
        return ++ncount;
    }
    
    public int mincrementAndGet()
    {
        return ++mcount;
    }
    
    public int get()
    {
        return count;
    }

    public void clear()
    {
        count = 0;
    }

    public int incrementAndGet()
    {
        return ++count;
    }

    public String toString()
    {
        return ""+count;
    }
    
}