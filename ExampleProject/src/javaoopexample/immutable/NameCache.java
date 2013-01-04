package javaoopexample.immutable;

import java.lang.ref.SoftReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class NameCache {
	private final String firstname;
	private final String lastname;
	private static final Set<SoftReference<NameCache>> names =  new HashSet<SoftReference<NameCache>>();
	
	public NameCache(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public static NameCache valueOf(String firstname, String lastname){
		Iterator<SoftReference<NameCache>> it = names.iterator();
		while (it.hasNext()){
			SoftReference<NameCache> ref = it.next();
			NameCache name = ref.get();
			if (name != null && name.firstname.equals(firstname) && name.lastname.equals(lastname)){
				return name;
			}
		}
		
		NameCache name = new NameCache(firstname, lastname);
		names.add(new SoftReference<NameCache>(name));
		return name;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result
				+ ((lastname == null) ? 0 : lastname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NameCache other = (NameCache) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Name [firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	
    	

}
