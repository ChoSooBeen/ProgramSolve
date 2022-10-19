#include<stdio.h>

int main(void)
{
	int n, m;
	int count = 1;
	int i;
	int k = 0;
	int num[5000] = { 0 };

	scanf("%d %d", &n, &m);
	printf("<");
	while(k <= n){
		for (i = 1; i <= n; i++) {
			if (num[i] == 1)
				count--;
			else if (count == m) {
				k++;
				num[i] = 1;
				if (k == n) {
					printf("%d>", i);
					k++;
				}
				else{
					printf("%d, ", i);
					count = 0;
				}
					
			}
			count++;
		}
	}
	return 0;
}
