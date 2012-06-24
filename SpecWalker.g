tree grammar SpecWalker;

options {
  tokenVocab = ReportSpec;
  ASTLabelType = CommonTree;
  output = template;
}

workbook : (s+=sheet)+ -> workbook( sheets={$s} ); 

sheet : ^('SHEET' ID) -> sheet( name={$ID.text} ); 
