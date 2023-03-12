package geeksForGeeks_1;

public class inheritance {
	

	
	public static void main(String[] args)
	{
		child c=new child();
		c.display();
	}

}


class parent{
	
	public void display()
	{
		System.out.println("Nikhil");
	}
	
}

class child extends parent{
	
	public void display()
	{
		System.out.println("Thulaseedharan");
	}
	
	public void show()
	{
		System.out.println("Display:");
	}
}

