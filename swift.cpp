#include<stdio.h>
#include<stdlib.h>
#include<conio.h>

void main()
{
	int x[12] = {1,2,3,4,5,6,7,8,9,10,11,12};
	int n = 12, rotdist = 3;
	int t = 0, j = 0, k;
	for(int i = 0; i < rotdist; i++)
	{
		t = x[i];
		j = i;
		do
		{
			k = j + rotdist;
			if(k >= n)
			{
				k -= n;
			}
			if(k == i) break;
			x[j] = x[k];
			j = k;
		}while(k != i);
		x[j] = t;
	}
	for(int m = 0; m < n; m++)
	{
		printf("%d ", x[m]);
	}
	getch();

}