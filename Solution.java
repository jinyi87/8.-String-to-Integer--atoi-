/*
 * 1.is Empty?
 * 2.remove Space
 * 3.Positive or Negative?
 * 4.overflow
 * */

public class Solution
{
	public int myAtoi(String str)
	{
		int index = 0;
		int sign = 1;
		int total = 0;
		if (str.length() == 0)
		{
			return 0;
		}
		while (str.charAt(index) == ' ')
		{
			index++;
			if (index >= str.length())
				return 0;
		}
		if (str.charAt(index) == '+' || str.charAt(index) == '-')
		{
			sign = str.charAt(index) == '-' ? -1 : 1;
			index++;
		}
		while (index < str.length())
		{
			int temp = str.charAt(index) - '0';
			if (temp < 0 || temp > 9)
				return total*sign;
			if (Integer.MAX_VALUE / 10 < total || (Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < temp))
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			total = total * 10 + temp;
			index++;
		}
		return total*sign;
	}
	
}