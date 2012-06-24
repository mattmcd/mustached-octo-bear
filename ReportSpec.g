grammar ReportSpec;

options {
  output = AST;
  ASTLabelType = CommonTree;
}

ID : ('a'..'z'|'A'..'Z')+;

WS : (' '|'\r'|'\n'|'\t')+ { $channel = HIDDEN; };

workbook  : sheet+;

sheet     : 'SHEET' ID -> ^('SHEET' ID);
