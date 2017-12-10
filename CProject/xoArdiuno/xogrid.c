/**
 * @Author: hiru
 * @Date:   2017-11-11T08:57:40+00:00
 * @Last modified by:   hiru
 * @Last modified time: 2017-11-13T18:57:13+00:00
 */



#include <stdio.h>
#include "graphics.h"
#include <unistd.h>

/*function declaration */
int setBoard(void);
int movePlayerTo0(void);
int movePlayerTo1(void);
int movePlayerTo2(void);
int movePlayerTo3(void);
int movePlayerTo4(void);
int movePlayerTo5(void);
int movePlayerTo6(void);
int movePlayerTo7(void);
int movePlayerTo8(void);
int playerMoveButton(void);
int markCell(void);
int checkIfWon(void);

//temp values for now NEED TO CHANGE
int cellStatus[9] = {0,0,0,0,0,0,0,0,0}; //0 - dont show, 1 - show x, 2 - show y
int count = 6;
int player = 1; //1 for X, 2 for O

//winning combos for X
int winX1[9] = {1,1,1,0,0,0,0,0,0};
int winX2[9] = {0,0,0,1,1,1,0,0,0};
int winX3[9] = {0,0,0,0,0,0,1,1,1};
int winX4[9] = {0,0,1,0,1,0,1,0,0};
int winX5[9] = {1,0,0,0,1,0,0,0,1};
int winX6[9] = {1,0,0,1,0,0,1,0,0};
int winX7[9] = {0,1,0,0,1,0,0,1,0};
int winX8[9] = {0,0,1,0,0,1,0,0,1};

//winning combos for O
int winO1[9] = {2,2,2,0,0,0,0,0,0};
int winO2[9] = {0,0,0,2,2,2,0,0,0};
int winO3[9] = {0,0,0,0,0,0,2,2,2};
int winO4[9] = {0,0,2,0,2,0,2,0,0};
int winO5[9] = {2,0,0,0,2,0,0,0,2};
int winO6[9] = {2,0,0,2,0,0,2,0,0};
int winO7[9] = {0,2,0,0,2,0,0,2,0};
int winO8[9] = {0,0,2,0,0,2,0,0,2};


//reset the board to black and then make chosen cell red
int movePlayerTo0(void){
  setColour(black);
  setBoard();
  setColour(red);
  drawRect(10, 10, 75, 75);
  setColour(black);
  return 0;
}

int movePlayerTo1(void){
  setColour(black);
  setBoard();
  setColour(red);
  drawRect(85, 10, 75, 75);
  setColour(black);
  return 0;
}

int movePlayerTo2(void){
  setColour(black);
  setBoard();
  setColour(red);
  drawRect(160, 10, 75, 75);
  setColour(black);
  return 0;
}

int movePlayerTo3(void){
  setColour(black);
  setBoard();
  setColour(red);
  drawRect(10, 85, 75, 75);
  setColour(black);
  return 0;
}

int movePlayerTo4(void){
  setColour(black);
  setBoard();
  setColour(red);
  drawRect(85, 85, 75, 75);
  setColour(black);
  return 0;
}

int movePlayerTo5(void){
  setColour(black);
  setBoard();
  setColour(red);
  drawRect(160, 85, 75, 75);
  setColour(black);
  return 0;
}

int movePlayerTo6(void){
  setColour(black);
  setBoard();
  setColour(red);
  drawRect(10, 160, 75, 75);
  setColour(black);
  return 0;
}

int movePlayerTo7(void){
  setColour(black);
  setBoard();
  setColour(red);
  drawRect(85, 160, 75, 75);
  setColour(black);
  return 0;
}

int movePlayerTo8(void){
  setColour(black);
  setBoard();
  setColour(red);
  drawRect(160, 160, 75, 75);
  setColour(black);
  return 0;
}

int setBoard(void){
  // set up grid
  drawRect(10, 10, 75, 75);
  drawRect(10, 85, 75, 75);
  drawRect(10, 160, 75, 75);
  drawRect(85, 10, 75, 75);
  drawRect(85, 85, 75, 75);
  drawRect(85, 160, 75, 75);
  drawRect(160, 10, 75, 75);
  drawRect(160, 85, 75, 75);
  drawRect(160, 160, 75, 75);
  return 0;
}

int markCell(void){
  //setting up all possible x and o positilns
  //x and o's
  if (cellStatus[0] == 1) {
    drawLine(20,20,70,70);
    drawLine(70,20,20,70);
  } else if (cellStatus[0] == 2) {
    drawOval(20,20,50,50);
  }

  if (cellStatus[1] == 1) {
    drawLine(95,20,145,70);
    drawLine(145,20,95,70);
  } else if (cellStatus[1] == 2){
    drawOval(95,20,50,50);
  }

  if (cellStatus[2] == 1) {
    drawLine(170,20,220,70);
    drawLine(220,20,170,70);
  } else if (cellStatus[2] == 2) {
    drawOval(170,20,50,50);
  }

  if (cellStatus[3] == 1) {
    drawLine(20,95,70,145);
    drawLine(70,95,20,145);
  } else if (cellStatus[3] == 2) {
    drawOval(20,95,50,50);
  }

  if (cellStatus[4] == 1) {
    drawLine(95,95,145,145);
    drawLine(145,95,95,145);
  } else if (cellStatus[4] == 2) {
    drawOval(95,95,50,50);
  }

  if (cellStatus[5] == 1) {
    drawLine(170,95,220,145);
    drawLine(220,95,170,145);
  } else if (cellStatus[5] == 2) {
    drawOval(170,95,50,50);
  }

  if (cellStatus[6] == 1) {
    drawLine(20,170,70,220);
    drawLine(70,170,20,220);
  } else if (cellStatus[6] == 2) {
    drawOval(20,170,50,50);
  }

  if (cellStatus[7] == 1) {
    drawLine(95,170,145,220);
    drawLine(145,170,95,220);
  } else if (cellStatus[7] == 2) {
    drawOval(95,170,50,50);
  }

  if (cellStatus[8] == 1) {
    drawLine(170,170,220,220);
    drawLine(220,170,170,220);
  } else if (cellStatus[8] == 2) {
    drawOval(170,170,50,50);
  }
  return 0;
}

int checkIfWon(void){
  if (cellStatus[8] == winX1[8] || cellStatus[8] == winX2[8] || cellStatus[8] == winX3[8] || cellStatus[8] == winX4[8] || cellStatus[8] == winX5[8] || cellStatus[8] == winX6[8] || cellStatus[8] == winX7[8] || cellStatus[8] == winX8[8]) {
    drawString("X won", 300, 150);
  } else if (cellStatus[8] == winO1[8] || cellStatus[8] == winO2[8] || cellStatus[8] == winO3[8] || cellStatus[8] == winO4[8] || cellStatus[8] == winO5[8] || cellStatus[8] == winO6[8] || cellStatus[8] == winO7[8] || cellStatus[8] == winO8[8]) {
    drawString("O won", 300, 150);
  } else {
    drawString("", 300, 150);
  }
  return 0;
}

int playerSelectButton(void){
  //test to see if cell is occupied
  if (cellStatus[count] == 0) {
    //if player is X
    if (player == 1) {
      cellStatus[count] = 1;
      player = 2;
    } else { //else is O
      cellStatus[count] = 2;
      player = 1;
    }
    markCell();
    checkIfWon();

  }
  return 0;
}

int playerMoveButton(void){
    if (count == 8) { //reset to 0
      count = count - 9;
    }
    count = count + 1;
    //run case statement
    //count value should reflect the highlighted cell
    switch (count) {
      case 0:
        movePlayerTo0();
        break;
      case 1:
        movePlayerTo1();
        break;
      case 3:
        movePlayerTo3();
        break;
      case 4:
        movePlayerTo4();
        break;
      case 5:
        movePlayerTo5();
        break;
      case 6:
        movePlayerTo6();
        break;
      case 7:
        movePlayerTo7();
        break;
      case 8:
        movePlayerTo8();
        break;
    }
    return 0;
}


int main(void) {
  setBoard();

  //everytime keyword select is read from serial then run this function
  playerSelectButton();

  //everytime keyword move is read from serial then run this function
  playerMoveButton();

  //scoreboard
  if (player == 1) {
    drawString("It is X's turn",285,110);
  } else if (player == 2) {
    drawString("It is O's turn",285,110);
  }

  return 0;
}
