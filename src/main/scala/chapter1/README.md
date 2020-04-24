# Chapter 1
A functional solution: removing the side effects

The functional solution is to eliminate side effects and have buyCoffee return the charge as a value in addition to returning the Coffee. The concerns of processing the charge by sending it off to the credit card company, persisting a record of it, and so on, will be handled elsewhere.