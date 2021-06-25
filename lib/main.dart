import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_native_sso/PlatformViewDemo.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key? key, required this.title}) : super(key: key);

  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  static const platform = const MethodChannel('ssoChannel');
  String _myName = 'Please Log in!';

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(child: PlatformViewDemo()),
      floatingActionButton: FloatingActionButton.extended(
        onPressed: () {
          _startSSO();
          print(_myName);
        },
        tooltip: 'Increment',
        icon: Icon(Icons.facebook),
        label: Text('Facebook'),
      ),
    );
  }

  Future<void> _startSSO() async {
    String myName;
    try {
      final String result = await platform.invokeMethod('startSSO');
      myName = result;
    } on PlatformException catch (e) {
      myName = "Failed To Login: '${e.message}'.";
    }

    setState(() {
      _myName = myName;
    });
  }
}
