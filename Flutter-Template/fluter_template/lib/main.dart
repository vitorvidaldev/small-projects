import 'package:fluter_template/pages/form.dart';
import 'package:fluter_template/pages/login.dart';
import 'package:fluter_template/pages/table.dart';
import 'package:flutter/material.dart';

import 'pages/login.dart';

void main() {
  runApp(const FlutterTemplate());
}

class FlutterTemplate extends StatelessWidget {
  const FlutterTemplate({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: "Flutter Template",
        debugShowCheckedModeBanner: false,
        theme: ThemeData(
          primarySwatch: Colors.purple,
        ),
        initialRoute: "/",
        routes: {
          "/": (context) => const PrimaryPage(),
          "/login": (context) => const LoginTemplate(),
          "/form": (context) => const FormTemplate(),
          "/table": (context) => const TableTemplate(),
        });
  }
}

class PrimaryPage extends StatelessWidget {
  const PrimaryPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Flutter Template"),
      ),
      body: Center(
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.center,
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            SizedBox(
              width: 300,
              child: ElevatedButton(
                onPressed: () {
                  Navigator.pushNamed(context, "/table");
                },
                child: const Text("Table Example"),
              ),
            ),
            const SizedBox(height: 30),
            SizedBox(
              width: 300,
              child: ElevatedButton(
                onPressed: () {
                  Navigator.pushNamed(context, "/form");
                },
                child: const Text("Form Example"),
              ),
            ),
            const SizedBox(height: 30),
            SizedBox(
              width: 300,
              child: ElevatedButton(
                onPressed: () {
                  Navigator.pushNamed(context, "/login");
                },
                child: const Text("Login Example"),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
