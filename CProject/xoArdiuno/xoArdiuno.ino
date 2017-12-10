/**
 * @Author: hiru
 * @Date:   2017-11-13T07:25:09+00:00
 * @Last modified by:   hiru
 * @Last modified time: 2017-11-13T18:28:21+00:00
 */



// set pin numbers for the five buttons:
const int moveButton = 2;
const int selectButton = 3;

int responseDelay = 200;


void setup() {
  // initialize the buttons' inputs:
  pinMode(moveButton, INPUT);
  pinMode(selectButton, INPUT);
  Serial.begin(9600);
}

void loop() {
  // read the buttons:
  int moveButtonState = digitalRead(moveButton);
  int selectButtonState = digitalRead(selectButton);

  // if the button1 is pressed:
  if (moveButtonState == HIGH) {
    Serial.print("move");
  }

  // if the button2 is pressed:
  if (selectButtonState == HIGH) {
    Serial.print("select");
  }

  delay(responseDelay);

}

