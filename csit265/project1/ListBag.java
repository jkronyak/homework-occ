//Jared Kronyak

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class ListBag<T> implements ListADT<T>, BagADT<T>
{
	private List<T> list;

	public ListBag()
	{
		list = new ArrayList<T>();
	}

	@Override
	public Iterator<T> iterator() 
	{
		Iterator<T> iterator = list.iterator();
		return iterator;
	}

	@Override
	public T removeRandom()
	{
		if(isEmpty())
			return null;
		return list.remove((int)Math.random() * size());
	}

	@Override
	public BagADT union(BagADT anotherBag)
	{
		
		BagADT unionBag = new ListBag<T>();
		BagADT<T> anotherBagCopy = new ListBag<T>();
		
		while(anotherBag.size() > 0)
		{
			anotherBagCopy.add((T)anotherBag.removeRandom());
		}
		
		while(anotherBagCopy.size() > 0)
		{
			T element = (T) anotherBagCopy.removeRandom();
			
			unionBag.add(element);
			anotherBag.add(element);
		}
		
		for(T element : list)
		{
			unionBag.add(element);
		}
		
		return unionBag;
		
		/*
		 *Old Solution using .iterator(). I opted not to use this, because it involves an unchecked casting
		 *of BagADT to ListBag, which works in this Project, but not in a theoretical project involving an alternate
		 *implementation of BagADT. 
		 
		BagADT<T> unionBag = new ListBag<T>();
		Iterator<T> itr = ((ListBag<T>) anotherBag).iterator();
		
		for(T element : list)
		{
			unionBag.add(element);
		}
		
		while(itr.hasNext())
		{
			unionBag.add(itr.next());
		}
	
		return unionBag;
		*/
	}

	@Override
	public boolean add(T element)
	{
		return list.add(element);
	}

	@Override
	public T get(int index)
	{
		return list.get(index);
	}

	@Override
	public T removeFirst()
	{
		return list.remove(0);
	}

	@Override
	public T removeLast() 
	{
		return list.remove(list.size() - 1);
	}

	@Override
	public T remove(T element) 
	{
		int index = list.indexOf(element);
		if(index == -1)
		{
			return null;
		}
		
		return list.remove(index);
	}

	@Override
	public T first()
	{
		return list.get(0);
	}

	@Override
	public T last() 
	{
		return list.get(list.size() - 1);
	}

	@Override
	public boolean contains(T target) 
	{
		return list.contains(target);
	}

	@Override
	public boolean isEmpty() 
	{
		return list.isEmpty();
	}

	@Override
	public int size()
	{
		return list.size();
	}
	
}
