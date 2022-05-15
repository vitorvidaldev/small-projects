import 'package:flutter/material.dart';

class LoginTemplate extends StatefulWidget {
  const LoginTemplate({Key? key}) : super(key: key);

  @override
  State<LoginTemplate> createState() => _LoginTemplateState();
}

class _LoginTemplateState extends State<LoginTemplate> {
  final _formKey = GlobalKey<FormState>();
  final _LoginData _data = _LoginData();

  @override
  Widget build(BuildContext context) {
    final screenSize = MediaQuery.of(context).size;

    void submit() {
      if (_formKey.currentState!.validate()) {
        _formKey.currentState!.save();
      }
    }

    return Scaffold(
      appBar: AppBar(
        title: const Text("Login Template Page"),
      ),
      body: Center(
        child: Container(
          padding: const EdgeInsets.all(20.0),
          child: Form(
            key: _formKey,
            child: SizedBox(
              width: 500,
              child: ListView(
                children: [
                  TextFormField(
                    keyboardType: TextInputType.emailAddress,
                    decoration: const InputDecoration(
                      hintText: "yourEmail@example.com",
                      labelText: "Email address",
                    ),
                    onSaved: (String? value) {
                      _data.email = value!;
                    },
                  ),
                  TextFormField(
                    obscureText: true,
                    decoration: const InputDecoration(
                      hintText: "Password",
                      labelText: "Enter your password",
                    ),
                    onSaved: (String? value) {
                      _data.password = value!;
                    },
                  ),
                  Container(
                    width: screenSize.width,
                    margin: const EdgeInsets.only(top: 20.0),
                    child: ElevatedButton(
                      onPressed: submit,
                      child: const Text(
                        "Login",
                        style: TextStyle(color: Colors.white),
                      ),
                    ),
                  ),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}

class _LoginData {
  String email = "";
  String password = "";
}
