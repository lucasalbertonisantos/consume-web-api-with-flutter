
import 'package:flutter/cupertino.dart';
import 'package:http/http.dart';

void findAll() async{
  final Response response = await get('http://192.168.99.1:8080/transactions');
  debugPrint(response.body);
}