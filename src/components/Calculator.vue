<template>
  <h2>{{ msg }}</h2>
  <div class="mainContainer">
    <div class="calculatorContainer">
      <div class="calculator-screen">{{ screen || "0" }}</div>
      <button type="button" class="all-clear" @click="clear">AC</button>
      <button type="button" class="sign" @click="sign">+/-</button>
      <button type="button" class="delete" @click="del">DEL</button>
      <button type="button" class="operator" @click="add">+</button>

      <button type="button" @click="append('1')">1</button>
      <button type="button" @click="append('2')">2</button>
      <button type="button" @click="append('3')">3</button>
      <button type="button" class="operator" @click="minus">-</button>

      <button type="button" @click="append('4')">4</button>
      <button type="button" @click="append('5')">5</button>
      <button type="button" @click="append('6')">6</button>
      <button type="button" class="operator" @click="times">&times;</button>

      <button type="button" @click="append('7')">7</button>
      <button type="button" @click="append('8')">8</button>
      <button type="button" @click="append('9')">9</button>
      <button type="button" class="operator" @click="divide">&divide;</button>

      <button type="button" class="blank" value=""></button>
      <button type="button" @click="append('0')">0</button>
      <button type="button" class="decimal" @click="dot">.</button>
      <button type="button" class="equal-sign" @click="equal">=</button>
    </div>

    <div class="logCointainer">
      <div class="containerHeader">
        <h2 id="h3">This is a log of recent equations</h2>
        <button id="clearButton" @click="clearLog">Clear</button>
      </div>
      <Log id="log" :logArray="logArray"></Log>
    </div>
  </div>
</template>

<script>
import Log from "@/components/Log";
import axios from "axios";

export default {
  data() {
    return {
      screen: "",
      operator: null,
      operatorSign: "+",
      operatorClicked: false,
      previous: "",
      logArray: [],
    };
  },
  components: {
    Log,
  },
  props: {
    msg: String,
  },
  methods: {
    clear() {
      this.screen = "";
    },
    sign() {
      this.screen =
        this.screen.charAt(0) === "-"
          ? this.screen.slice(1)
          : `-${this.screen}`;
    },
    del() {
      this.screen = this.screen.slice(0, -1);
    },
    append(number) {
      if (this.operatorClicked) {
        this.screen = "";
        this.operatorClicked = false;
      }
      this.screen += number;
    },
    dot() {
      if (this.screen.indexOf(".") === -1) {
        this.append(".");
      }
    },
    add() {
      this.operatorSign = "+";
      this.previous = this.screen;
      this.operatorClicked = true;
    },
    minus() {
      this.operatorSign = "-";
      this.previous = this.screen;
      this.operatorClicked = true;
    },
    divide() {
      this.operatorSign = "/";
      this.previous = this.screen;
      this.operatorClicked = true;
    },
    times() {
      this.operatorSign = "*";
      this.previous = this.screen;
      this.operatorClicked = true;
    },
    equal(){
      const calculatorRequest = {
        operand1: this.previous,
        operatorSign: this.operatorSign,
        operand2: this.screen,
      };
      let storeScreen = this.screen;
      const calculatorResponse = axios.post(
          "http://localhost:8085/demo/calculate",
          calculatorRequest
      );
      calculatorResponse.then((resolvedResult) => {
        this.screen = resolvedResult.data.screen;
        this.logArray.push(this.previous + this.operatorSign + storeScreen +  " = " + this.screen);
        this.previous = "";
      });
    },
    clearLog() {
      this.logArray.splice(0, this.logArray.length);
    },
  },
};
</script>

<style scoped>
.mainContainer {
  display: flex;
  flex-direction: row;
  margin: 0 auto;
  width: 1100px;
  vertical-align: center;
}
.calculatorContainer {
  width: 500px;
  margin: 0 auto;
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-auto-rows: minmax(100px, auto);
  padding: 30px;
  border: 1px solid gray;
  background-color: darkgray;
  border-radius: 25px;
  grid-gap: 8px;
}
.logCointainer {
  width: 500px;
  margin: 0 auto;
  padding: 30px;
  background-color: darkgray;
  border-radius: 25px;
  border: 1px solid gray;
}

.calculator-screen {
  grid-column: 1/5;
  width: 100%;
  font-size: 5rem;
  height: 98px;
  border: none;
  background-color: #252525;
  color: #fff;
  text-align: center;
  margin-bottom: auto;
  border-radius: 10px;
}

button {
  height: 99px;
  border-radius: 8px;
  border: 1px solid black;
  background-color: #333333;
  color: white;
  font-size: 2rem;
  text-align: center;
  background-image: linear-gradient(
    to bottom,
    transparent,
    transparent 50%,
    rgba(0, 0, 0, 0.04)
  );
  box-shadow: inset 0 0 0 1px rgba(255, 255, 255, 0.05),
    inset 0 1px 0 0 rgba(255, 255, 255, 0.45),
    inset 0 -1px 0 0 rgba(255, 255, 255, 0.15),
    0 1px 0 0 rgba(255, 255, 255, 0.15);
  text-shadow: 0 1px rgba(255, 255, 255, 0.4);
}
button:hover {
  background-color: #eaeaea;
}
.operator {
  color: #252525;
  background-color: seagreen;
}

.all-clear {
  background-color: darkslategrey;
  border-color: black;
  color: black;
}

.all-clear:hover {
  background-color: #f17377;
}

.equal-sign {
  background-color: limegreen;
  border-color: #337cac;
  color: #fff;
}

.equal-sign:hover {
  background-color: #4e9ed4;
}
#clearButton {
  height: 30px;
  width: 50px;
  border: 1px solid black;
  background-color: #252525;
  color: #fff;
  vertical-align: middle;
  margin: 0 auto;
  font-size: smaller;
  text-align: center;
  font-weight: revert;
  border-radius: 10px;
  font-family: Avenir, Helvetica, Arial, sans-serif;
}
#h3 {
  text-align: left;
  margin: auto;
  color: darkslategrey;
}

.containerHeader {
  display: flex;
  flex-direction: row;
  width: 500px;
  margin: 0 auto;
}
</style>
