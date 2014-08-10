#include <stdlib.h>
#include <stdio.h>

int StrToInt(char* string){
  int number = 0;
  while(*string != 0 ){
    number = number * 10 + *string - '0';
    printf("%d\n", number);
    ++string;
  }
  return number;
}

int main(){
  char* test = "1234";
  int number = StrToInt(test);
  printf("%d",number);
  return 0;
}
