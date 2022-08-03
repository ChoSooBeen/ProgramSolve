//나누기 연산
#include<stdio.h>

int main()
{
	int num1, num2;
	double result;
	scanf("%d %d", &num1, &num2);
	result = (double)num1 / num2;
	printf("%.9f", result);
	return 0;
}
