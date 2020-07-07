/*
 ============================================================================
 Name        : HelloPThread.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <pthread.h>
#include <stdio.h>
#include <stdbool.h>
#include <unistd.h>


int data = 0;
int number = 0;
bool available = 0;
pthread_mutex_t derMutex;
pthread_cond_t dieCondition;



void put(int number) {
	int id = pthread_self();
	while(available){
		printf("[producer]:: Thread %d geraet in WAITING \n", id);
		pthread_cond_wait(&dieCondition, &derMutex);
		printf("[put]:: Thread %d macht weiter \n", id);
	}
	data = number;
	available = 1;
	pthread_cond_broadcast(&dieCondition);

			}

int get() {
	int id = pthread_self();
	while(!(available)){

		printf("[get]:: Thread %d geraet in WAITING \n ", id);
		pthread_cond_wait(&dieCondition, &derMutex);
		printf("[get]:: Thread %d macht weiter \n", id);
	}
	available = 0;
	pthread_cond_broadcast(&dieCondition);
	return 0;
}

void* consumer(void * unused) {

	while(1){
		pthread_mutex_lock (&derMutex);
		get();
		 int id = pthread_self();
		 printf("[consume]:: Thread %d hat Zahl %d konsumiert \n", id, data);
		pthread_mutex_unlock (&derMutex);
	}
}

void* produce(void* unused) {

	while(1){
		pthread_mutex_lock(&derMutex);
		number++;
		int id = pthread_self();
		printf("[producer]:: Thread %d hat Zahl %d produziert \n", id, number);
		put(number);
		pthread_mutex_unlock (&derMutex);
	}
}


int main() {

pthread_t producerThread1;
pthread_t producerThread2;
pthread_t producerThread3;
pthread_t consumerThread1;
pthread_t consumerThread2;

pthread_cond_init(&dieCondition, NULL);
pthread_mutex_init(&derMutex, NULL);

pthread_create(&producerThread1, NULL, &produce, NULL);
pthread_create(&producerThread2, NULL, &produce, NULL);
pthread_create(&producerThread3, NULL, &produce, NULL);
pthread_create(&consumerThread1, NULL, &consumer, NULL);
pthread_create(&consumerThread2, NULL, &consumer, NULL);

pthread_join(producerThread1, NULL);
/* Print o’s continuously */

return 0;
}
