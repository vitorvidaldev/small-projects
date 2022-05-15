import 'package:flutter/material.dart';

class TableTemplate extends StatefulWidget {
  const TableTemplate({Key? key}) : super(key: key);

  @override
  State<TableTemplate> createState() => _TableTemplateState();
}

class _TableTemplateState extends State<TableTemplate> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Table Template Page"),
      ),
      body: Center(
        child: SizedBox(
          width: MediaQuery.of(context).size.width * 0.8,
          child: ListView(
            children: [
              const Center(
                child: Text(
                  "People Chart",
                  style: TextStyle(
                    fontSize: 25,
                    fontWeight: FontWeight.bold,
                  ),
                ),
              ),
              DataTable(
                columns: [
                  columnAttribute("ID"),
                  columnAttribute("Name"),
                  columnAttribute("Profession"),
                ],
                rows: const [
                  DataRow(cells: [
                    DataCell(Text('1')),
                    DataCell(Text('Stephen')),
                    DataCell(Text('Actor')),
                  ]),
                  DataRow(cells: [
                    DataCell(Text('5')),
                    DataCell(Text('John')),
                    DataCell(Text('Student')),
                  ]),
                  DataRow(cells: [
                    DataCell(Text('10')),
                    DataCell(Text('Harry')),
                    DataCell(Text('Leader')),
                  ]),
                  DataRow(cells: [
                    DataCell(Text('15')),
                    DataCell(Text('Peter')),
                    DataCell(Text('Scientist')),
                  ]),
                ],
              ),
            ],
          ),
        ),
      ),
    );
  }

  DataColumn columnAttribute(String attributeName) {
    return DataColumn(
      label: Text(
        attributeName,
        style: const TextStyle(
          fontSize: 18,
          fontWeight: FontWeight.bold,
        ),
      ),
    );
  }
}
