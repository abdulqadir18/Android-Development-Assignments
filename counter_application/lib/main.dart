// use to import All material app components
import 'package:flutter/material.dart';

//---------Basic
//NoteBook = MaterialApp
//Page = Scaffold

//---------Everything in flutter is widgets
// appbar -> top fixed header
// bnb -> bottom navigation bar
// tabview -> navigation bar other than bnb
// fab -> floating action button
// component -> distinct piece of section, not clearly visible
// card -> distinct piece of section, visible

//----------types of widgets
//1. stateless -> data type/properties remains same
//2. stateful -> data type/ ui changes
void main() {
  runApp(const MyApp());
}

// ------------stateless MyApp class
class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Counter Application',
      home: const LandingPage(),
      // theme: ThemeData.dark(),
      theme: ThemeData(primarySwatch: Colors.green),
    );
  }
}

// ----------stateful LandingPage class
class LandingPage extends StatefulWidget {
  const LandingPage({Key? key}) : super(key: key);

  @override
  State<LandingPage> createState() => _LandingPageState();
}

//const -> where items not change eg-> hello world but not in eg-> column
class _LandingPageState extends State<LandingPage> {
  // _ for variable to be used in single or same page
  int _counter = 0;

  void increment() {
    // when state changes -> setState does it
    setState(() {
      _counter = _counter + 1;
      print('Counter: $_counter');
    });
  }

  void decrement() {
    // when state changes -> setState does it
    setState(() {
      _counter = _counter - 1;
      print('Counter: $_counter');
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      //---------AppBar
      appBar: AppBar(
        title: const Text('Counter Application'),
      ),

      //-------Body
      // body: const Text('Hello World'),

      body: Center(
        child: Column (
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: [Row(
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children : [
            Column(
              // crossAxisAlignment: CrossAxisAlignment.stretch,
              children: [
              const Text(
              'Counter',
                style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
              ),
                Text(
                  '$_counter',
                  style: TextStyle(fontSize: 24, color: Colors.blue),
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                  children: [
                    ElevatedButton(
                        onPressed: increment,
                        style: ElevatedButton.styleFrom(shape: const CircleBorder()),
                        child: const Padding(
                          padding: EdgeInsets.all(10),
                          child: Icon(Icons.add),
                        )

                    ),
                    const SizedBox(width: 10),
                    ElevatedButton(
                        onPressed: decrement, child: const Icon(Icons.remove)),
                  ],
                )
                ],
              ),
                Column(
                  children: [
                  const Text(
                  'Counter',
                  style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
                ),
                Text(
                  '$_counter',
                  style: TextStyle(fontSize: 24, color: Colors.blue),
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                  children: [
                    ElevatedButton(
                        onPressed: increment, child: const Icon(Icons.add)),
                    const SizedBox(width: 10),
                    ElevatedButton(
                        onPressed: decrement, child: const Icon(Icons.remove)),
                  ],
                )
              ],
            ),
          ],
        ),

      Row(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            const Text(
              'Counter',
              style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
            Text(
              '$_counter',
              style: TextStyle(fontSize: 24, color: Colors.blue),
            ),
            Row(
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                ElevatedButton(
                    onPressed: increment, child: const Icon(Icons.add)),
                const SizedBox(width: 10),
                ElevatedButton(
                    onPressed: decrement, child: const Icon(Icons.remove)),
              ],
            )
          ],
        ),
          ],
      ),
        ],
        ),

        // child: Column(
        //   mainAxisAlignment: MainAxisAlignment.center,
        //   children: [
        //     const Text(
        //       'Counter',
        //       style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
        //     ),
        //     Text(
        //       '$_counter',
        //       style: TextStyle(fontSize: 24, color: Colors.blue),
        //     ),
        //     Row(
        //       mainAxisAlignment: MainAxisAlignment.spaceEvenly,
        //       children: [
        //         ElevatedButton(
        //             onPressed: increment, child: const Icon(Icons.add)),
        //         ElevatedButton(
        //             onPressed: decrement, child: const Icon(Icons.remove)),
        //       ],
        //     )
        //   ],
        // ),

        // child: Text(
        //   'Hello World',
        //   style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
        // ),
      ),

      //--------FAB
      // floatingActionButton: FloatingActionButton(
      //   onPressed: (){
      //
      //   },
      //   child: const Icon(Icons.add),
      // ),
    );
  }
}
