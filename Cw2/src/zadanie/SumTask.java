package zadanie;

public class SumTask implements Task<SumResult>
{
	int a;
	int b;
	SumResult rt = new SumResult();
	
	public SumTask(int a, int b)
	{
		this.a = a;
		this.b = b;
	}
	
	@Override
	public SumResult execute()
	{
		rt.result = a+b;
		return rt;
	}

}
