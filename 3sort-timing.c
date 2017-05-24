//libraries
#include <stdio.h>
#include <math.h>
#include <time.h>


//functions

//QS-> Quick Sort (with exclusion of sorted element)+ Partitioning of Hoare
//183,168-169page + extra lectures notes
void QSE(int A[], int p, int r) 
{
if (p<r)
 {
		int q = HPE(A, p, r);
		QSE(A, p, q-1);
		QSE(A, q+1, r);
 }
}

//HPE - Hoare's partitioning with returned element of division
//extra lectures notes
int HPE (int A[], int p, int r) 
{
	int x = A[r]; 
	int i = p-1, j=0;
	int swap=0;
	for (j=p ; j<=r-1 ; j++) 
		{
		if (A[j]<=x) 
		 {
	    	i = i+1;
    		swap = A[i];
			A[i] = A[j];
			A[j] = swap;
		 }
		}
	swap = A[i+1];
	A[i+1] = A[r];
	A[r] = swap;
	return i+1;
}
//QS-> Quick Sort (with exclusion of sorted element)+ Partitioning of Hoare


//sort by insertion book page 15-17
void InsertS( int tab[], int size ) 
{
	int temp, x, y;

	for( x = 1; x < size; x++ ) 
		{
		temp = tab[x];
		y=x-1;
		while ( y = x - 1; y >= 0 && tab[y] > temp)
		{
			tab[y+1] = tab[y];
			y--;
		}
		//for( y = x - 1; y >= 0 && tab[y] > temp; y-- ) 
			//tab[y+1] = tab[y];
		tab[y+1] = temp;
		}
} 
//sort by insertion book page 15-17



//MAX-HEAP lectures March
int parent(int i) 
{ 
	return i/2; 
};

int left(int i) 
{ 
	if(i==0) 
		return 1; 
	else 
		return 2*i; 
}; 

int right(int i) 
{ 
	if(i==0) 
		return 2; 
	else 
		return 2*i+1; 
};


void buildMAXheap(int t[], int Q) 
{
	int i;
	for (i = Q/2; i >= 0; --i)
		maxheapify(t,i,Q);
}


void maxheapify(int A[], int i, int n) 
{
	int largest;
	int l = left(i);
	int r = right(i);
	if (l<n && A[l] > A[i])
		largest = l;
	else
		largest = i;

	if (r< n && A[r] > A[largest])
		largest = r;

	if (largest != i) {
	int x;
	x=A[i];
	A[i]=A[largest];
	A[largest]=x;
	maxheapify(A, largest, n);
	}
}


void maxheapsort(int A[], int N)
{
	buildMAXheap(A, N);
	int i,x;
	int n = N;
	for (i = N-1; i >= 1; --i) 
	{
		x = A[0];
		A[0] = A[i];
		A[i] = x;
		--n;
		maxheapify(A, 0, n);
	}
}
////MAX-HEAP lectures March

//array print out
void printTab(int A[], int n) 
{
	int i;
	for (i=0; i < n; i++) 
	{
		printf("%d \n", A[i]);
	}
	printf("\n");
}
//array print out




void main() 
{

	//deifne size by number of elements
	#define SETi 120000
	int v;
	int A1[SETi], A2[SETi], A3[SETi]; //arays for 3 kinds of sorts
	int r = sizeof(A)/sizeof(A[0]); 

	//printf("rozmiar=%d\n",r);

	//random initialization + generation from max INT
	//max int as used signed ints.
	srand(time(0));
	for (v = 0; v<r; ++v) 
	{
		A1[v] = rand() % 2147483647;
		A2[v] = A1[v];
		A3[v] = A2[v];
	}
	printf("\nUnsorted table-quantity of %d elements):\n",S); 
	//clock_t tStart = clock(); clock_t tEnd = clock();

	tStart = clock();
	maxheapsort(A1, r);
	tEnd = clock();
	printf("Heapsort timing= %3.2f s\n", 
			( (double)(tEnd - tStart) / (double)CLOCKS_PER_SEC ) );
	tStart = clock();
	InsertS(A2, r); 
	tEnd = clock();
	printf("Insertionsort timing= %3.2f s\n", 
			( (double)(tEnd -tStart) / (double)CLOCKS_PER_SEC ) );
	tStart = clock();
	QSE(A3, 0, r-1); 
	tEnd = clock();
	printf("Quicksort (pointed element)= %3.2f s\n", 
			( (double)(tEnd - tStart) / (double)CLOCKS_PER_SEC ) );


	printf("\nSorted table-quantity of %d elements):\n",S);

	tStart = clock();
	maxheapsort(A1, r); 
	tEnd = clock();
	printf("Heapsort timing= %3.2f s\n", 
			( (double)(tEnd - tStart) / (double)CLOCKS_PER_SEC ) );
	tStart = clock();
	tStart = clock();
	InsertS(A2, r); 
	tEnd = clock();
	printf("Insertionsort timing= %3.2f s\n", 
			( (double)(tEnd -tStart) / (double)CLOCKS_PER_SEC ) );
	tStart = clock();
	QSE(A3, 0, r-1); 
	tEnd = clock();
	printf("Quicksort (pointed element)= %3.2f s\n", 
			( (double)(tEnd - tStart) / (double)CLOCKS_PER_SEC ) );

	printTab(A1, r);
	printTab(A3, r);
	printTab(A2, r);
}