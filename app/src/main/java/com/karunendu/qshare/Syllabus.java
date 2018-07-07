package com.karunendu.qshare;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Syllabus extends AppCompatActivity{

    private Spinner spinner1, spinner2;
    private Button btnSubmit;
    private String syllabus,s1,s2;
    TextView titleText;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_syllabus);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ActionBar ab=getSupportActionBar();
        ab.setDisplayShowTitleEnabled(false);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowCustomEnabled(true);
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#34495e")));
        LayoutInflater inflater=getLayoutInflater();

        View view=inflater.inflate(R.layout.action_bar_home,null);
        titleText=(TextView)view.findViewById(R.id.titleText);
        titleText.setText("Syllabus");
        ActionBar.LayoutParams lp=new ActionBar.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                Gravity.CENTER
        );
        ab.setCustomView(view,lp);
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();
               }
    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }
    public void getSyllabus() {
         s1 = String.valueOf(spinner1.getSelectedItem());
         s2 = String.valueOf(spinner2.getSelectedItem());
        if(s1.equals("MCA"))
        {
          if ( s2.equals("I"))
            {
              syllabus = "Semester I:\n" +
                      "1. Discrete Mathematical Structures (MCA-101)\n" +
                      "2. Accounting & Financial Management (MCA-102)\n" +
                      "3. Digital Electronics & Computer Organization(MCA-103)\n" +
                      "4. Combinatorics & Graph Theory (MCA-104)\n" +
                      "5. C Programming & Numerical Methods (MCA-105)\n" +
                      "6. Linux & Shell Programming (MCA-106)\n" +
                      "Lab I : Programming in C in Linux environment\n" +
                      "Lab II: Assembly language Programming & Simulation Experiments\n" +
                      "Lab.III: Communication Skills Lab.\n\n" +
                      "Paper-1: Discrete Mathematical Structures (MCA-101)\n" +
                      "8 Lectures\n" +
                      "1. Mathematical Logic: Introduction, Statements and notation, Connectives, Statement formula and truth tables, Wellformed\n" +
                      "formula, duality law, Tautological implications, Functionally complete set of connectives\n" +
                      " Normal forms: conjunctive and disjunctive normal forms, Principal conjunctive and disjunctive normal forms, Ordering &\n" +
                      "uniqueness of normal forms.\n" +
                      " Predicate Calculus: Predicates, Statement function, Variables & quantifiers, Predicate formulas, Theory of inference for\n" +
                      "the predicate calculus\n" +
                      "8 Lectures\n" +
                      "2. Set Theory, Relations and Functions: Basic concepts of set theory, Finite & Infinite sets, Equality of sets, The power\n" +
                      "set, Venn Diagrams, Cartesian Products, Cardinality of sets.\n" +
                      "Definition and properties of relations & functions, Matrix & Graph representation of relations, Covering of set\n" +
                      "equivalence relations, Composition of relation & functions, Inverse function, Characteristic function of a set\n" +
                      "8 Lectures\n" +
                      "3. Principle of inclusion & exclusion: First principle, Inclusion & Exclusion principle in general & their applications\n" +
                      "6 Lectures\n" +
                      "4. Algebraic structures: Overview of Group theory, Semi group, Monoid, Groupoid, Finite & Infinite group, Abelian group\n" +
                      "and their examples\n" +
                      "10 Lectures\n" +
                      "5. Latices and Boolean Algebra: Poset, Hasse diagram, Elements of Poset, Bounds, Lattices, Join, Meet, Different types\n" +
                      "of lattices and their examples\n" +
                      "Reference:\n" +
                      "1. Logic for CS by Gallier\n" +
                      "2. Discrete Maths by Tremblay Manohar\n" +
                      "3. Discrete Maths by Stanat\n" +
                      "4. Laws of Logical Calculi by Morgan\n" +
                      "Paper-2: ACCOUNTING & FINANCIAL MANAGEMENT (MCA-102)\n" +
                      "4 Lectures\n" +
                      "1. Accounting: Principles, concepts and conventions, double entry system of accounting, Ledger posting and Trial\n" +
                      "balance.\n" +
                      "4 Lectures\n" +
                      "2. Final accounts: Trading, profit and loss accounts and balance sheet of sole proprietary concern with normal closing\n" +
                      "entries. Introduction to manufacturing account, final account of partnership firms, limited company.\n" +
                      "4 Lectures\n" +
                      "3. Financial Management: Meaning, role and scope of financial management.\n" +
                      "4 Lectures\n" +
                      "4. Basic Financial concepts: Time value of Money, present value, future value of a series of cash flows, annuity.\n" +
                      "Practical applications of compounding and present value techniques.\n" +
                      "4 Lectures\n" +
                      "5. Long-term sources of finance: Introduction to shares, debentures, preference shares.\n" +
                      "4 Lectures\n" +
                      "6. Capital Budgeting: Meaning, importance, difficulties. Introduction to evaluation techniques – Traditional techniques\n" +
                      "(ARR Payback method). Discounting cash flow techniques(Present value, NPV, IRR)\n" +
                      "4 Lectures\n" +
                      "7. Ratio Analysis: Meaning, advantages, limitations of ratio analysis, Types of ratios and their usefulness.\n" +
                      "2 Lectures\n" +
                      "8. Costing: Nature, importance and types of cost\n" +
                      "4 Lectures\n" +
                      "9. Marginal costing: Nature, scope and importance of marginal costing, Break-even analysis, its uses and limitations,\n" +
                      "construction of break-even charts. Practical applications of marginal costing.\n" +
                      "2 Lectures\n" +
                      "10. Inventory control system: The need, cost of inventory, methods of inventory costing.\n" +
                      "4 Lectures\n" +
                      "11. Introduction to Computerized Accounting System: Coding logic and codes required, master files, transaction files,\n" +
                      "introduction to documents used for data collection. Processing of different files and outputs obtained.\n" +
                      "References:\n" +
                      "1. S.N. Maheswari & S. K. Maheswari, “Introduction to Financial Accountancy”, Vikas Publication.\n" +
                      "2. S.N. Maheswari & S. K. Maheswari, “Advanced Accountancy”, Vikas Publication.\n" +
                      "3. S.N. Maheswari & S. K. Maheswari, “Financial Management”, Viaks Publication.\n" +
                      "Paper-3: DIGITAL ELECTRONICS & COMPUTER ORGANIZATION (MCA-103)\n" +
                      "10 Lectures\n" +
                      "1. Representation of Information and Basic Building Blocks\n" +
                      "Introduction to Computer, Computer hardware generation, Number System: Binary, Octal, Hexadecimal, Character Codes\n" +
                      "(BCD, ASCII, EBCDIC), Logic gates, Boolean Algebra, K-map simplification, Half Adder, Full Adder, Subtractor, Decoder,\n" +
                      "Encoders, Multiplexer, Demultiplexer, Carry lookahead adder, Combinational logic Design, Flip-Flops, Registers, Counters\n" +
                      "(synchronous & asynchronous), ALU, Micro-Operation.\n" +
                      "4 Lectures\n" +
                      "2. ALU- chip, Faster Algorithm and Implementation (multiplication & Division)\n" +
                      "6 Lectures\n" +
                      "3. Basic Organization: Von Neumann Machine (IAS Computer), Operational flow chart (Fetch, Execute), Instruction Cycle,\n" +
                      "Organization of Central Processing Unit, Hardwired & micro programmed control unit, Single Organization, General\n" +
                      "Register Organization, Stack Organization, Addressing modes, Instruction formats, data transfer & Manipulation, I/O\n" +
                      "Organization, Bus Architecture, Programming Registers\n" +
                      "6 Lectures\n" +
                      "4. Memory Organization : Memory Hierarchy, Main memory (RAM/ROM chips), Auxiliary memory, Associative memory,\n" +
                      "Cache memory, Virtual Memory, Memory Management Hardware, hit/miss ratio, magnetic disk and its performance,\n" +
                      "magnetic Tape etc.\n" +
                      "6 Lectures\n" +
                      "5. I/O Organization\n" +
                      "Peripheral devices, I/O interface, Modes of Transfer, Priority Interrupt, Direct Memory Access, Input-Output Processor,\n" +
                      "and Serial Communication. I/O Controllers, Asynchronous data transfer, Strobe Control, Handshaking.\n" +
                      "8 Lectures\n" +
                      "6. Process Organization: Basic Concept of 8-bit micro Processor (8085) and 16-bit Micro Processor (8086), Assembly\n" +
                      "Instruction Set, Assembly language program of (8085): Addition of two numbers, Subtraction, Block Transfer, find greatest\n" +
                      "number, Table search, Numeric Manipulation, Introductory Concept of pipeline, Flynn’s and Feng’s Classification, Parallel\n" +
                      "Architectural classification.\n" +
                      "References:\n" +
                      "1. William Stalling, “Computer Organization & Architecture”, Pearson education Asia\n" +
                      "2. Mano Morris, “Computer System Architecture”, PHI\n" +
                      "3. Zaky & Hamacher, “Computer Organization”, McGraw Hill\n" +
                      "4. B. Ram, “Computer Fundamental Architecture & Organization”, New Age\n" +
                      "5. Tannenbaum, “ Structured Computer Organization”, PHI.\n" +
                      "Paper-4: COMBINATORICS & GRAPH THEORY (MCA-104)\n" +
                      "4 Lectures\n" +
                      "1. Discrete numeric function and generating function, Combinatorial problems, Difference equation.\n" +
                      "4 Lectures\n" +
                      "2. Recurrence Relation-Introduction, Linear recurrence relation with constant coefficient,\n" +
                      "4 Lectures\n" +
                      "3. Homogeneous solution, Particular solution, Total solution, Solution by the method of generating function.\n" +
                      "8 Lectures\n" +
                      "4. Graphs, sub-graphs, some basic properties, Walks, Path & circuits, Connected graphs, Disconnected graphs and\n" +
                      "component, Eular and Hamiltonian graphs, Various operation on graphs, Tree and fundamental circuits, Distance\n" +
                      "diameters, Radius and pendent vertices, Rooted and binary trees, Counting trees, Spanning trees, Finding all\n" +
                      "spanning trees of a graph and a weighted graph.\n" +
                      "8 Lectures\n" +
                      "5. Cut-sets and cut vertices, some properties, All cut sets in a graph, Fundamental circuit and cut sets, Connectivity and\n" +
                      "seperatability, Network flows, mincut theorem, Planar graphs, Combinatorial and geometric dual, Kuratowski to graph\n" +
                      "detection of planarity, Geometric dual, Some more criterion of planarity, Thickness and Crossings, Vector space of a\n" +
                      "graph and vectors, basis vectors, cut set vector, circuit vector, circuit and cut set verses sub spaces, orthogonal\n" +
                      "vector and sub space.\n" +
                      "4 Lectures\n" +
                      "6. Incidence matrix of graphs, sub matrices of A(G), circuit matrix, cut set matrix, path matrix and relationship among Af,\n" +
                      "Bf, Cf, fundamental circuit matrix and range of Bf adjacency matrix, rank nullity theorem.\n" +
                      "8 Lectures\n" +
                      "7. Coloring and covering partitioning of graph, Chromatic number, Chromatic partitioning, Chromatic polynomials,\n" +
                      "Matching, covering, Four color problem, Directed graph, Types of directed graphs, Directed paths and\n" +
                      "connectedness, Euler digraph, Trees with directed edges, Fundamental circuit in digraph, Matrices A, B, C of digraph\n" +
                      "adjacency matrix of digraph, Enumeration and its types, Counting of labeled and unlabeled trees, Polya’s theorem,\n" +
                      "Graph enumeration with polyas theorem, Graph theoretic algorithm.\n" +
                      "References:\n" +
                      " 1. Deo Narsing, “Graph Theory with applications to engineering & computer science”, PHI\n" +
                      " 2. Tremblay & Manohar, “ Discrete mathematical structures with applications to computer\n" +
                      " Science”, TMH\n" +
                      " 3. Joshi K. D., “Fundamental of discrete mathematics”, New Age International\n" +
                      " 4. John Truss, “Discrete mathematics for computer scientist”\n" +
                      " 5. C. L. Liu, “Discrete mathematics”\n" +
                      "Paper-5: C Programming & Numerical Methods (MCA-105)\\nn" +
                      "4 Lectures\n" +
                      "1. Programming in C : History, Introduction to C, Structure of C programs, Compilation & execution of C programs,\n" +
                      "Debugging techniques, Data types & sizes, Declaration of variables, Modifiers, Identifiers & keywords, Symbolic constants\n" +
                      "12 Lectures\n" +
                      "2. C Language Features:Operators: Unary operators, Arithmetic & Logical operators, Bit-wise operators, Assignment\n" +
                      "operators and expressions, Conditional expressions, Precedence & order of evaluation;Control statements: If-else,\n" +
                      "Switch, Break, Continue, Comma operator, Go-to statement;Loops: For, While, Do-while;Functions: Built-in & Userdefined,\n" +
                      "Function declaration, Definition & function call, Parameter passing: Call by value, Call by reference, Recursive\n" +
                      "functions, Multi-file programs, Command line parameters;Arrays: Linear arrays, Multi-dimensional arrays, Passing arrays\n" +
                      "to functions, Arrays & Strings;Storage classes: Automatic, External, Register & Static, Enumerations;C Directives:\n" +
                      "Macros, C pre-processor;Structures & Union: Definition and differences, Self-referential structure;Pointers: Value at (*)\n" +
                      "and address of (&) operator, Pointer to pointer, Dynamic memory allocation, Calloc & Malloc functions, Array of pointers,\n" +
                      "Function of pointers, Structures and pointers, Linked list: Single, Double, Circular;File Handling in C: Opening, Closing\n" +
                      "and creating a data file, Read and Write functions, Unformatted data files\n" +
                      "24 Lectures\n" +
                      "3. Numerical Methods:Floating point Arithmetic: Representation of floating point numbers, Operations, Normalization,\n" +
                      "Pitfalls of floating point representation, Errors in numerical computation ;Iterative Methods: Zeros of a single\n" +
                      "transcendental equation and zeros of polynomial using Bisection Method, Iteration Method, Regula-Falsi method, Newton\n" +
                      "Raphson method, Secant method, Rate of convergence of iterative methods.;Simultaneous Linear Equations: Solutions\n" +
                      "of system of Linear equations, Gauss Elimination direct method and pivoting, Ill Conditioned system of equations,\n" +
                      "Refinement of solution. Gauss Seidal iterative method, Rate of Convergence;Interpolation and approximation: Finite\n" +
                      "Differences, Difference tables;Polynomial Interpolation: Newton’s forward and backward formula;Central Difference\n" +
                      "Formulae: Gauss forward and backward formula, Stirling’s, Bessel’s, Everett’s formula;\n" +
                      "Interpolation with unequal intervals: Langrange’s Interpolation, Newton Divided difference formula, Hermite’s\n" +
                      "Interpolation\n" +
                      "Approximation of function by Taylor’s series and Chebyshev polynomial;Numerical Differentiation and Integration:\n" +
                      "Introduction, Numerical Differentiation, Numerical Integration, Trapezoidal rule, Simpson’s rules, Boole’s Rule, Weddle’s\n" +
                      "Rule Euler- Maclaurin Formula;Solution of differential equations: Picard’s Method, Euler’s Method, Taylor’s Method,\n" +
                      "Runge-Kutta methods, Predictor-corrector method, Automatic error monitoring, stability of solution;Curve fitting, Cubic\n" +
                      "Spline and Approximation: Method of least squares, fitting of straight lines, polynomials, exponential curves\n" +
                      "etc;Frequency Chart: Different frequency chart like Histogram, Frequency curve, Pi-chart;Regression analysis: Linear\n" +
                      "and Non-linear regression, Multiple regression ;Time series and forecasting: Moving averages, smoothening of curves,\n" +
                      "forecasting models and methods. Statistical Quality Controls methods;\n" +
                      "References:\n" +
                      "1. Peter Norton’s, DOS Guide, PHI\n" +
                      "2. Gottfried, Programming in C, Schaum series, TMH\n" +
                      "3. Yashwant Kanitkar, Let us C, BPB\n" +
                      "4. Gerald & Wheatley, “Applied Numerical Analyses”, AW\n" +
                      "5. Jain, Iyengar and Jain, “Numerical Methods for Scientific and Engineering Computations”, New Age Int.\n" +
                      "6. Grewal B. S., “Numerical methods in Engineering and Science”, Khanna Publishers, Delhi\n" +
                      "7. Francis Scheld, “Numerical Analysis”, TMH\n" +
                      "Paper-6: LINUX AND SHELL PROGRAMMING (MCA-106)\n" +
                      "5 Lectures\n" +
                      "1. Introduction\n" +
                      "Introduction to LINUX, LINUX system organization (the kernel and the shell), Files and directories, Library functions and\n" +
                      "system calls, Editors (vi and ed).\n" +
                      "14 Lectures\n" +
                      "2. LINUX Shell programming : Types of Shells, Shell Meta characters, Shell variables, Shell scripts, Shell commands, the\n" +
                      "environment, Integer arithmetic and string Manipulation, Special command line characters, Decision making and Loop\n" +
                      "control, controlling terminal input, trapping signals, arrays.\n" +
                      "6 Lectures\n" +
                      "3. Portability with C: Command line Argument, Background processes, process synchronization, Sharing of data, user-id,\n" +
                      "group-id, pipes, fifos, message queues.\n" +
                      "6 Lectures\n" +
                      "4. LINUX System Administration : File System, mounting and unmounting file system, System booting, shutting down,\n" +
                      "handling user account, backup, recovery, security, creating files, storage of Files, Disk related commands.\n" +
                      "9 Lectures\n" +
                      "5. Different tools and Debugger : System development tools: lint, make, SCCS (source code control system), Language\n" +
                      "development tools: YACC, LEX, M4, Text formatting tools: nroff, troff, tbl, eqn, pic, Debugger tools: Dbx and Adb.\n" +
                      "References:\n" +
                      "1. Linux Networking & System Administration, Terry Collings and Kurt Wall (Wiley)\n" +
                      "2. Red Hat Linux 9, Bill Ball and Hoyt Duff (Pearson Education)\n";
             }
            else if (s2.equals("II"))
            {
                syllabus = "Semester II:\n" +
                        "1. Organizational Management and MIS (MCA-201)\n" +
                        "2. Data Structures (MCA-202)\n" +
                        "3. Database Management System (MCA-203)\n" +
                        "4. Operating Systems (MCA-204)\n" +
                        "5. Object Oriented Methodology using C++ (MCA-205)\n" +
                        "6. Theory of Computation (MCA-206)\n" +
                        "Lab I : Data Structures Lab.\n" +
                        "Lab II: Programming in C++\n" +
                        "Lab.III: Oracle Lab.\n" +
                        "Paper-1: Organizational Management and MIS (MCA-201)\n" +
                        "3 Lectures\n" +
                        "1. Organization Structure: Classical theories of Management: Scientific management theory, Fayol’s 14 principles of\n" +
                        "Management, Webar’s bureaucratic theory. Definition of organization and organization Structure.\n" +
                        "3 Lectures\n" +
                        "2. Some concepts regarding Organization Structure: Line and Staff authority, Centralization and Decentralization,\n" +
                        "Span of control, Formal and Informal Organization.\n" +
                        "3 Lectures\n" +
                        "3. Forms of organization structure and features: Function based, Product based, Geography based, Project based (\n" +
                        "Matrix)\n" +
                        "3 Lectures\n" +
                        "4. Organization Design: Mechanistic and Organic Structure, Virtual and Network organization Structure\n" +
                        "4 Lectures\n" +
                        "5. Motivation: Definition of Motivation, Importance of Motivation, Motivation and behavior, Theories of Motivation –\n" +
                        "Maslows need Hierarchy, Two- Factor Theory, McClelland ‘s Need Theory, Theory X and Theory Y.\n" +
                        "4 Lectures\n" +
                        "6. Foundation of Information Systems: Introduction to information system in business, fundamentals of information\n" +
                        "systems, Solving business problems with information systems, Types of information systems, Effectiveness and\n" +
                        "efficiency criteria in information system.\n" +
                        "4 Lectures\n" +
                        "7. An overview of Management Information Systems: Definition of a management information system, MIS versus\n" +
                        "Data processing, MIS & Decision Support Systems, MIS & Information Resources Management, End user computing,\n" +
                        "Concept of an MIS, Structure of a Management information system.\n" +
                        "4 Lectures\n" +
                        "8. Concepts of planning & control: Concept of organizational planning, The Planning Process, Computational support\n" +
                        "for planning, Characteristics of control process, The nature of control in an organization.\n" +
                        "4 Lectures\n" +
                        "9. Business applications of information technology: Internet & electronic commerce, Intranet, Extranet & Enterprise\n" +
                        "Solutions, Information System for Business Operations, Information System for Managerial Decision Support,\n" +
                        "Information System for Strategic Advantage.\n" +
                        "4 Lectures\n" +
                        "10. Managing Information Technology: Enterprise & global management, Security & Ethical challenges, Planning &\n" +
                        "Implementing changes.\n" +
                        "4 Lectures\n" +
                        "11. Advanced Concepts in Information Systems: Enterprise Resource Planning, Supply Chain Management,\n" +
                        "Customer Relationship Management, and Procurement Management.\n" +
                        "References:\n" +
                        "1. O Brian, “Introduction to Information System”, MCGRAW HILL.\n" +
                        "2. Murdick, “Information System for Modern Management”, PHI.\n" +
                        "3. Jawadekar, “ Management Information System”, TMH.\n" +
                        "4. Jain Sarika, “Information System”, PPM\n" +
                        "5. Davis, “Information System”, Palgrave Macmillan\n" +
                        " 6. L. M. Prasad, “Organizational Behavior”, S. Chand.\n" +
                        "7. Koontz, Weihrich, “Essentials of Management”, TMH\n" +
                        "8. K. Aswathappa, “Human Resource and Personnel Management”, TMH\n" +
                        "9. L. M. Prasad, “Human Resourse Management”, S. Chand\n" +
                        "Paper-2: DATA & FILE STRUCTURE USING ‘C’ (MCA-202)\n" +
                        "3 Lectures\n" +
                        "1. Introduction: Basic Terminology, Elementary Data Organization, Data Structure operations, Algorithm Complexity\n" +
                        "and Time-Space trade-off\n" +
                        "2 Lectures\n" +
                        "2. Arrays: Array Definition, Representation and Analysis, Single and Multidimensional Arrays, address calculation,\n" +
                        "application of arrays, Character String in C, Character string operation, Array as Parameters, Ordered List, Sparse\n" +
                        "Matrices, and Vectors.\n" +
                        "4 Lectures\n" +
                        "3. Stacks: Array Representation and Implementation of stack, Operations on Stacks: Push & Pop, Array Representation\n" +
                        "of Stack, Linked Representation of Stack, Operations Associated with Stacks, Application of stack: Conversion of Infix\n" +
                        "to Prefix and Postfix Expressions, Evaluation of postfix expression using stack.\n" +
                        "4 Lectures\n" +
                        "4. Queues: Array and linked representation and implementation of queues, Operations on Queue: Create, Add, Delete,\n" +
                        "Full and Empty. Circular queue, Deque, and Priority Queue.\n" +
                        "6 Lectures\n" +
                        "5. Linked list: Representation and Implementation of Singly Linked Lists, Two-way Header List, Traversing and\n" +
                        "Searching of Linked List, Overflow and Underflow, Insertion and deletion to/from Linked Lists, Insertion and deletion\n" +
                        "Algorithms, Doubly linked list, Linked List in Array, Polynomial representation and addition, Generalized linked list,\n" +
                        "Garbage Collection and Compaction.\n" +
                        "5 Lectures\n" +
                        "6. Trees: Basic terminology, Binary Trees, Binary tree representation, algebraic Expressions, Complete Binary Tree.\n" +
                        "Extended Binary Trees, Array and Linked Representation of Binary trees, Traversing Binary trees, Threaded Binary\n" +
                        "trees. Traversing Threaded Binary trees, Huffman algorithm.\n" +
                        "3 Lectures\n" +
                        "7. Searching and Hashing: Sequential search, binary search, comparison and analysis, Hash Table, Hash Functions,\n" +
                        "Collision Resolution Strategies, Hash Table Implementation.\n" +
                        "4 Lectures\n" +
                        "8. Sorting: Insertion Sort, Bubble Sorting, Quick Sort, Two Way Merge Sort, Heap Sort, Sorting on Different Keys,\n" +
                        "Practical consideration for Internal Sorting.\n" +
                        "5 Lectures\n" +
                        "9. Binary Search Trees: Binary Search Tree (BST), Insertion and Deletion in BST, Complexity of Search Algorithm,\n" +
                        "Path Length, AVL Trees, B-trees.\n" +
                        "4 Lectures\n" +
                        "10. File Structures: Physical Storage Media File Organization, Organization of records into Blocks, Sequential Files,\n" +
                        "Indexing and Hashing, Primary indices, Secondary indices, B+ Tree index Files, B Tree index Files, Indexing and\n" +
                        "Hashing Comparisons\n" +
                        "References\n" +
                        "1. Horowitz and Sahani, “Fundamentals of data Structures”, Galgotia\n" +
                        "2. R. Kruse etal, “Data Structures and Program Design in C” Pearson Education\n" +
                        "3. A M Tenenbaum etal, “Data Structures using C & C++”, PHI\n" +
                        "4. Lipschutz, “Data Structure”, TMH\n" +
                        "5. K Loudon, “Mastering Algorithms With C”, Shroff Publisher & Distributors\n" +
                        "6. Bruno R Preiss, “Data Structures and Algorithms with Object Oriented Design Pattern in C++”, Jhon Wiley &\n" +
                        "Sons, Inc.\n" +
                        "7. Adam Drozdek, “Data Structures and Algorithms in C++”, Thomson Asia\n" +
                        "8. Pal G. Sorenson, “An Introduction to Data Structures with Application”, TMH.\n" +
                        "Paper-3: DATA BASE MANAGEMENT SYSTEM (MCA-203)\n" +
                        "3 Lectures\n" +
                        "1. Introduction: An overview of database management system, Database System Vs File System, Database system\n" +
                        "concepts and architecture, data models schema and instances, data independence and data base language and\n" +
                        "interfaces, Data definitions language, DML, Overall Database Structure.\n" +
                        "6 Lectures\n" +
                        "2. Data Modeling using the Entity Relationship Model: ER model concepts, notation for ER diagram, mapping\n" +
                        "constraints, keys, Concepts of Super Key, candidate key, primary key, Generalization, aggregation, reduction of an ER\n" +
                        "diagrams to tables, extended ER model, relationships of higher degree.\n" +
                        "5 Lectures\n" +
                        "3. Relational data Model and Language: Relational data model concepts, integrity constraints: entity integrity, referential\n" +
                        "integrity, Keys constraints, Domain constraints, relational algebra, relational calculus, tuple and domain calculus.\n" +
                        "6 Lectures\n" +
                        "4. Introduction to SQL: Characteristics of SQL, Advantages of SQL, SQL data types and literals, Types of SQL commands,\n" +
                        "SQL operators and their procedure, Tables, views and indexes, Queries and sub queries, Aggregate functions, Insert,\n" +
                        "update and delete operations, Joins, Unions, Intersection, Minus, Cursors in SQL. PL/SQL, Triggers and clusters.\n" +
                        "6 Lectures\n" +
                        "5. Data Base Design & Normalization: Functional dependencies, normal forms, first, second, third normal forms, BCNF,\n" +
                        "inclusion dependencies, loss less join decompositions, normalization using FD, MVD, and JDs, alternative approaches to\n" +
                        "database design.\n" +
                        "6 Lectures\n" +
                        "6. Transaction Processing Concepts: Transaction system, Testing of serializability, Serializability of schedules, conflict &\n" +
                        "view serializable schedule, recoverability, Recovery from transaction failures, log based recovery, checkpoints, deadlock\n" +
                        "handling.\n" +
                        "8 Lectures\n" +
                        "7. Concurrency Control Techniques: Concurrency control, locking Techniques for concurrency control, Time stamping\n" +
                        "protocols for concurrency control, validation based protocol, multiple granularity, Multi-version schemes, Recovery with\n" +
                        "concurrent transaction. Transaction Processing in Distributed system, data fragmentation. Replication and allocation\n" +
                        "techniques for distributed system, overview of concurrency control and recovery in distrusted database.\n" +
                        "References:\n" +
                        "1 Date C J, “An Introduction To Database System”, Addision Wesley\n" +
                        "2 Korth, Silbertz, Sudarshan, “Database Concepts”, McGraw Hill\n" +
                        "3 Elmasri, Navathe, “Fundamentals Of Database Systems”, Addision Wesley\n" +
                        "4 Paul Beynon Davies, “Database Systems”, Palgrave Macmillan\n" +
                        "Paper-4: OPERATING SYSTEMS (MCA-204)\n" +
                        "3 Lectures\n" +
                        "1. Introduction: Definition and types of operating systems, Batch Systems, multi programming, time–sharing parallel,\n" +
                        "distributed and real-time systems, Operating system structure, Operating system components and services, System calls,\n" +
                        "system programs, Virtual machines.\n" +
                        "10 Lectures\n" +
                        "2. Process Management: Process concept, Process scheduling, Cooperating processes, Threads, Interprocess\n" +
                        "communication, CPU scheduling criteria, Scheduling algorithms, Multiple-processor scheduling, Real-time scheduling and\n" +
                        "Algorithm evaluation.\n" +
                        "10 Lectures\n" +
                        "3. Process Synchronization and Deadlocks: The Critical-Section problem, synchronization hardware, Semaphores,\n" +
                        "Classical problems of synchronization, Critical regions, Monitors, Deadlocks-System model, Characterization, Deadlock\n" +
                        "prevention, Avoidance and Detection, Recovery from deadlock, Combined approach to deadlock handling.\n" +
                        "8 Lectures\n" +
                        "4. Storage management: Memory Management-Logical and Physical Address Space, Swapping, Contiguous Allocation,\n" +
                        "Paging, Segmentation with paging in MULTICS and Intel 386, Virtual Memory, Demand paging and its performance, Page\n" +
                        "replacement algorithms, Allocation of frames, Thrasing, Page Size and other considerations, Demand segmentation, File\n" +
                        "systems, secondary Storage Structure, File concept, access methods, directory implementation, Efficiency and\n" +
                        "performance, recovery, Disk structure, Disk scheduling methods, Disk management, Recovery, Disk structure, disk\n" +
                        "scheduling methods, Disk management, Swap-Space management, Disk reliability.\n" +
                        "5 Lectures\n" +
                        "5. Security & Case Study: Protection and Security-Goals of protection, Domain of protection, Access matrix,\n" +
                        "Implementation of access Matrix, Revocation of Access Rights, language based protection, The Security problem,\n" +
                        "Authentication, One Time passwords, Program threats, System threats, Threat Monitoring, Encryption.\n" +
                        "4 Lectures\n" +
                        "6. Windows NT-Design principles, System components, Environmental subsystems, File system, Networking and program\n" +
                        "interface, Linux system-design principles, Kernel Modules, Process Management, Scheduling, Memory management, File\n" +
                        "Systems, Input and Output, Interprocess communication, Network structure, security\n" +
                        "References:\n" +
                        "1. Abraham Siberschatz and Peter Baer Galvin, “Operating System Concepts”, Fifth Edition, Addision-Wesley\n" +
                        " 2. Milan Milankovic, “Operating Systems, Concepts and Design”, McGraw-Hill.\n" +
                        "3. Harvey M Deital, \"Operating Systems\", Addison Wesley\n" +
                        "4. Richard Peterson, “Linux: The Complete Reference”, Osborne McGraw-Hill.\n" +
                        "Paper-5: OBJECT ORIENTED METHODOLOGY USING C++ (MCA-205)\n" +
                        "7 Lectures\n" +
                        "1. Object Modeling Object & classes, Links and Associations, Generalization and Inheritance, Aggregation, Abstract\n" +
                        "classes, A sample object model, Multiple Inheritance, Meta data, candidate keys, constraints.\n" +
                        "9 Lectures\n" +
                        "2. Dynamic Modeling Events and States, Operations and Methods, Nested state Diagrams, Concurrency, Relation of\n" +
                        "Object and Dynamic Models, advanced dynamic model concepts, a sample dynamic model.\n" +
                        "6 Lectures\n" +
                        "3. Functional Modeling Functional Models, Data flow Diagrams, Specifying Operations, Constraints, a sample functional\n" +
                        "model.\n" +
                        "18 Lectures\n" +
                        "4. Programming in C++: Classes and objects in C++, Functions, Constructors, Destructors, Inheritance, Functions\n" +
                        "overloading, Operator Overloading, I/O Operations. Real life applications, Extended Classes, Pointer, Virtual functions,\n" +
                        "Polymorphisms, Working with files, Class templates, Function templates. Translating object oriented design into an\n" +
                        "implementation, OMT Methodologies, examples and case studies to demonstrate methodology, comparison of\n" +
                        "Methodology, SA/SD, and JSD.\n" +
                        "References\n" +
                        " 1. Rambaugh James etal, “Object Oriented Design and Modeling”, PHI-1997\n" +
                        " 2. Bjarne Stroustrup, “C++ Programming Language”, Addison Wesley\n" +
                        " 3. Balagurusamy E, “Object Oriented Programming with C++”, TMH, 2001\n" +
                        " 4. Booch Grady, “Object Oriented Analysis and Design with application 3/e”, Pearson\n" +
                        " 5. Lipman, Stanley B, Jonsce Lajole, “ C++ Primer Reading”, AWL, 1999\n" +
                        " 6. Dillon and Lee, “Object Oriented Conceptual Modeling”, New Delhi PHI-1993\n" +
                        " 7. Stephen R. Shah, “Introduction to Object Oriented Analysis and Design”, TMH\n" +
                        " 8. Berzin Joseph, “Data Abstraction: the object oriented approach using C++”, McGraw Hill\n" +
                        " 9. Mercer, “Computing Fundamental with C++”, Palgrave Macmillan\n" +
                        "Paper-6: Theory of Computation (MCA-206)\n" +
                        "6 Lectures\n" +
                        "Formal Languages\n" +
                        "Strings; Free semi-group; Languages; Generative grammars and their languages; Chomsky classification of grammars and\n" +
                        "languages\n" +
                        "8 Lectures\n" +
                        "Finite Automata\n" +
                        "Deterministic & Non-deterministic finite automata; Machines with moves on empty strings, regular expressions, Regular sets,\n" +
                        "Relationship with regular grammars, Pumping lemma for regular sets and its usage, Closure property of regular sets, Decision\n" +
                        "algorithm for regular sets, Minimization of Finite Automata\n" +
                        "4 Lectures\n" +
                        "Context Free Grammars\n" +
                        "Derivation Trees, Simplification of context free grammars, Chomsky normal form, Greibach normal form, Decision algorithm\n" +
                        "6 Lectures\n" +
                        "Pushdown Automata\n" +
                        "Instantaneous description, languages accepted my final states and empty stacks, deterministic pushdown automata, relationship\n" +
                        "with context free language.\n" +
                        "10 Lectures\n" +
                        "Turing Machines:\n" +
                        "Instantaneous description, Languages, String manipulation, Turing computability of functions, Equivalence between Turing\n" +
                        "Computability and partial recursiveness.\n" +
                        "6 Lectures\n" +
                        "Undecidability:\n" +
                        "Recursively enumerable and recursively decidable languages, Undecidability of decision algorithm for Type 0 grammar, Church\n" +
                        "Turing thesis, Halting problem of mchine.\n" +
                        "References:\n" +
                        "1. Automata, Languages & Computation Hopcraft & Ullman\n" +
                        "2. Theory of computability Hennie\n" +
                        "3. Formal languages Revesz\n" +
                        "4. Theory of Computer Science K L P Mishra & Chandrashekharan\n";
            }
            else if (s2.equals("III"))
            {
                syllabus = "Semester III:\n" +
                        "1. Software Engineering & Case Tools(MCA-301)\n" +
                        "2. Design & Analysis of Algorithms (MCA-302)\n" +
                        "3. Web Technologies using JAVA (MCA-303)\n" +
                        "4. Computer Graphics (MCA-404)\n" +
                        "5. System Programming (MCA-405)\n" +
                        "6. Advanced Computer Architecture (MCA-306)\n" +
                        "Lab I : Programming in Java\n" +
                        "Lab II: Computer Graphics Lab.\n" +
                        "Lab.III: Systems Programming Lab.\n" +
                        "Paper-1: SOFTWARE ENGINEERING AND CASE TOOLS (MCA-301)\n" +
                        "5 Lectures\n" +
                        "1. Introduction: Introduction to software engineering, Importance of software, The evolving role of software, Software\n" +
                        "Characteristics, Software Components, Software Applications, Software Crisis, Software engineering problems, Software\n" +
                        "Development Life Cycle, Software Process.\n" +
                        "5 Lectures\n" +
                        "2. Software Requirement Specification: Analysis Principles, Water Fall Model, The Incremental Model, Prototyping, Spiral\n" +
                        "Model, Role of management in software development, Role of matrices and Measurement, Problem Analysis,\n" +
                        "Requirement specification, Monitoring and Control.\n" +
                        "5 Lectures\n" +
                        "3. Software-Design: Design principles, problem partitioning, abstraction, top down and bottom up-design, Structured\n" +
                        "approach, functional versus object oriented approach, design specifications and verification, Monitoring and control,\n" +
                        "Cohesiveness, coupling, Forth generation techniques, Functional independence, Software Architecture, Transaction and\n" +
                        "Transform Mapping, Component – level Design, Forth Generation Techniques\n" +
                        "5 Lectures\n" +
                        "4. Coding: Top-Down and Bottom –Up programming, structured programming, information hiding, programming style and\n" +
                        "internal documentation.\n" +
                        "5 Lectures\n" +
                        "5. Testing: Testing principles, Levels of testing, functional testing, structural testing, test plane, test case specification,\n" +
                        "reliability assessment, software testing strategies, Verification & validation, Unit testing, Integration Testing, Alpha & Beta\n" +
                        "testing, system testing and debugging.\n" +
                        "5 Lectures\n" +
                        "6. Software Project Management: The Management spectrum- (The people, the product, the process, the project), cost\n" +
                        "estimation, project scheduling, staffing, software configuration management, Structured Vs. Unstructured maintenance,\n" +
                        "quality assurance, project monitoring, risk management.\n" +
                        "5 Lectures\n" +
                        "7. Software Reliability & Quality Assurance: Reliability issues, Reliability metrics, Reliability growth modeling, Software\n" +
                        "quality, ISO 9000 certification for software industry, SEI capability maturity model, comparison between ISO & SEI CMM.\n" +
                        "5 Lectures\n" +
                        "8. CASE (Computer Aided Software Engineering): CASE and its Scope, CASE support in software life cycle,\n" +
                        "documentation, project management, internal interface, Reverse Software Engineering, Architecture of CASE\n" +
                        "environment.\n" +
                        "References\n" +
                        "1. Pressman, Roger S., “Software Engineering: A Practitioner’s Approach Ed. Boston: McGraw Hill, 2001\n" +
                        "2. Jalote, Pankaj, “Software Engineering Ed.2”, New Delhi: Narosa 2002\n" +
                        "3. Schaum’s Series, “Software Engineering”, TMH\n" +
                        "4. Ghezzi, Carlo and Others, “Fundamentals of Software Engineering”, PHI\n" +
                        "5. Alexis, Leon and Mathews Leon, “Fundamental of Software Engineering”, Vikas\n" +
                        "6. Sommerville, Ian, “Software Engineering”, AWL, 2000\n" +
                        "7. Fairly, “Software Engineering”, New Delhi: TMH\n" +
                        "8. Pfleerger, S, “Software Engineering”, Macmillan, 1987\n" +
                        "Paper-2: DESIGN AND ANALYSIS OF ALGORITHMS (MCA-302)\n" +
                        "8 Lectures\n" +
                        "1. Introduction: Algorithms, Analysis of Algorithms, Design of Algorithms, and Complexity of Algorithms, Asymptotic\n" +
                        "Notations, Growth of function, Recurrences Sorting in polynomial Time: Insertion sort, Merge sort, Heap sort, and Quick\n" +
                        "sort Sorting in Linear Time: Counting sort, Radix Sort, Bucket Sort\n" +
                        "8 Lectures\n" +
                        "2. Advanced Data Structure: Binary Search Tree,Red Black Trees, Augmenting Data Structure, B-Tree, Priority Queues,\n" +
                        "Binomial Heap, Fibonacci Heap, Mergeable heaps, Data Structure for Disjoint Sets and Union-find Algorithm.\n" +
                        "12 Lectures\n" +
                        "3. Advanced Design and Analysis Techniques: Greedy Algorithm: General Approach, Knapsack Problem, Huffman\n" +
                        "Code; Dynamic programming: General approach, Multistage graph, Matrix- chain multiplication, Longest common\n" +
                        "subsequence, Knapsack problem; Backtracking: N-queen problem, Sum of subsets, Knapsack problem, Travelling\n" +
                        "salesperson problem; Branch-and-Bound: Assignment problem, 0/1 knapsack problem; Amortized Analysis\n" +
                        "12 Lectures\n" +
                        "4. a. Elementary Graph Algorithms: Breadth first search, depth first search\n" +
                        "b. Application of BFS, DFS: Connected component, Topological sort\n" +
                        "c. Minimum Spanning Tree: Kruskal's Algorithms, Prim's Algorithms\n" +
                        "d. Shortest Path: Single Source: Dijkstra, Bellman Ford; All pair shortest Path: Floyd's Algorithms\n" +
                        "e. Maximum flow: Flow networks and Ford Fulkerson algorithms\n" +
                        "f. String Matching: Naïve, Rabin-Karp, KMP Algorithms\n" +
                        "g. Number Theortic Algorithms: Factorization, GCD, Modular Arithmetic\n" +
                        "h. Randomized Algorithms: Randomized Quick-Sort\n" +
                        "i. Theory of NP-Completeness: P, NP, NP-Complete, NP Hard\n" +
                        "j. Approximation Algorithms: Travelling Salesman Problem\n" +
                        "k. Computational Geometry: Convex Hull\n" +
                        "References\n" +
                        "1. Horowitz Sahani, “ Fundamentals of Computer Algorithms”, Golgotia\n" +
                        "2. Cormen Leiserson etal, “ Introduction to Algorithms”, PHI\n" +
                        "3. Brassard Bratley, “Fundamental of Algorithms”, PHI\n" +
                        "4. M T Goodrich etal, “Algorithms Design”, John Wiley\n" +
                        "5. A V Aho etal, “The Design and analysis of Algorithms”, Pearson Education\n" +
                        "Paper-3: WEB TECHNOLOGIES USING JAVA (MCA-303)\n" +
                        "13 Lectures\n" +
                        "1. Programming in Java: Core Java: Introduction, Operator, Data type, Variable, Arrays, Control Statements, Methods &\n" +
                        "Classes, Inheritance, Package and Interface, Exception Handling, Multithread programming, I/O, Java Applet, String\n" +
                        "handling, Networking, Event handling, Introduction to AWT, AWT controls, Layout managers, Menus, Images, Graphics.\n" +
                        "4 Lectures\n" +
                        "2. Communication Issues, the Client, Multi-departmental & Large scale Websites, Quality Assurance and testing,\n" +
                        "Technological advances and Impact on Web Teams.\n" +
                        "5 Lectures\n" +
                        "3. HTML: Formatting Tags, Links, List, Tables, Frames, forms, Comments in HTML, DHTML.\n" +
                        "8 Lectures\n" +
                        "4. JavaScript: Introduction, Documents, Documents, forms, Statements, functions, objects in JavaScript, Events and Event\n" +
                        "Handling, Arrays, FORMS, Buttons, Checkboxes, Text fields and Text areas.\n" +
                        "5 Lectures\n" +
                        "5. XML: Introduction, Displaying an XML Document, Data Interchange with an XML document, Document type definitions,\n" +
                        "Parsers using XML, Client-side usage, Server Side usage.\n" +
                        "5 Lectures\n" +
                        "6. Common Gateway Interface (CGI), PERL, RMI, COM/DCOM, VBScript, Active Server Pages (ASP).\n" +
                        "Referneces:\n" +
                        " 1. Burdman, “Collaborative Web Development”, Addison Wesley.\n" +
                        " 2. Sharma &Sharma, “Developing E-Commerce Sites”, Addison Wesley\n" +
                        " 3. Ivan Bayross, “Web Technologies Part II”, BPB Publications.\n" +
                        " 4. Margaret Levine Young, “The Complete Reference Internet”, TMH\n" +
                        " 5. Naughton, Schildt, “The Complete Reference JAVA2”, TMH\n" +
                        " 6. Balagurusamy E, “Programming in JAVA”, TMH\n" +
                        " 7. Shishir Gundavarma, “CGI Programming on the World Wide Web”, O’Reilly & Associate.\n" +
                        " 8. DON Box, “Essential COM”, Addison Wesley.\n" +
                        " 9. Greg Buczek, “ASP Developer’s Guide”, TMH\n" +
                        "Paper-4: COMPUTER GRAPHICS (MCA-304)\n" +
                        "5 Lectures\n" +
                        "1. Introduction to Computer Graphics\n" +
                        "Introduction, Graphics display devices, Graphics Input & Output devices, Raster scan graphics, Line and Circle generation\n" +
                        "techniques, Scan conversion, Frame buffer, Filling algorithms.\n" +
                        "8 Lectures\n" +
                        "2. Geometrical Transformation\n" +
                        "Two dimensional transformations, Clipping and windowing methods for 2D images, Three dimensional transformations, Parallel and\n" +
                        "perspective projections, Viewing transformations and viewing systems.\n" +
                        "12 Lectures\n" +
                        "3. Curves and Surfaces\n" +
                        "Parametric and non-parametric curves and their representations, Cubic splines, Bezier and B-splines, Parametric surfaces,\n" +
                        "Surfaces of revolution, Sweep surfaces, Quadric surfaces, Bilinear surfaces, B-spline and Bezier surfaces, Generalized cylinders\n" +
                        "and cones, Polygon mesh and wire.\n" +
                        "15 Lectures\n" +
                        "4. 3-D Graphics\n" +
                        "Hidden lines and hidden surfaces, floating horizon algorithm, Robert algorithm, Phong Reflection model, Incremental shading\n" +
                        "techniques, Gouraud and Phong Shading, rendering process, Z – buffer algorithm, Scan Line and Area Coherence Methods,\n" +
                        "Introduction to Ray Tracing.\n" +
                        "References:\n" +
                        "1. Computer Graphics: Principles and Practices- Foley et al.\n" +
                        "2. Computer Graphics: Hearn and Baker\n" +
                        "3. Procedural elements in Computer Graphics: David F. Rozers\n" +
                        "4. Mathematical Elements for Computer Graphics- David F. Rozers\n" +
                        "Paper-5: SYSTEM PROGRAMMING (MCA -305)\n" +
                        "10 Lectures\n" +
                        "1-Language Processors: Introduction; Language Processing Activities; Fundamentals of Language Processing: Fundamentals of\n" +
                        "Language Specifications; Data Structures for Language Processing; Scanning & Parsing\n" +
                        "10 Lectures\n" +
                        "2- Assemblers: Elements of Assembly Language Programming; A Simple Assembly Scheme; Pass Structure of Assemblers;\n" +
                        "Types of Assemblers; Assembler Directives; Design of a Two Pass Assembler; Macros and Macro Processors; Nested Macro\n" +
                        "Calls; Advanced Macro Facilities; Design of a Macro Preprocessor\n" +
                        "10 Lectures\n" +
                        "3-Compilers and Interpreters: Aspects of Compilation; Memory Allocation; Lexical analysis – DFA diagrams; Syntactic analysisBottom\n" +
                        "up & Top Down Parsing; Symbol Tables – Hash & Tree Structures, Parse trees, Semantic analysis; Syntax Directed\n" +
                        "Translation; Compilation of Expressions; Compilation of Control Structures; Code generation & Optimization; Register utilization;\n" +
                        "10 Lectures\n" +
                        "4- Linkers: Relocation & Linking concepts; Design of a Linker; Self relocating Programs; A Linker for MS-DOS; Linking for\n" +
                        "overlays; Loaders; Types of Loaders & Linkers\n" +
                        "References :\n" +
                        "1. Hopcroft, Sethi and Ullman, Compiler Principles, AddisonWesley\n" +
                        "2. John Levine, Linkers and Loaders, http://www.iecc.com\n" +
                        "3. info lex and info bison on GNU/Linux Systems\n" +
                        "4. H. Abelson and G. Sussmann, Structure and Interpretation of Computer Programs, MIT Press\n" +
                        "5. Hopcroft and Ullman, Introduction to Automata theory, Languages and Computation, Narosa Pub.\n" +
                        "6. Systems Programming & Operating Systems- D M Dhamdhere THM\n" +
                        "Paper-6: ADVANCED COMPUTER ARCHITECTURE (MCA-306)\n" +
                        "8 Lectures\n" +
                        "1- Difference between scalar, scalar pipeline, scalar superpipeline and superscalar architecture; Pipelining Processing: An\n" +
                        "overlapped parallelism, Instruction and Arithmetic pipelines; Comparative study of 16 bit and 32 bit processor families; Basics of\n" +
                        "Pentium Processors; Comparative study of Microcontrollers; Future Trends\n" +
                        "4 Lectures\n" +
                        "2-Introduction to Parallel computing; Parallelism in Uni-processor Systems, Parallel computer Structures , Architectural\n" +
                        "Classification schemes, parallel processing applications..\n" +
                        "6 Lectures\n" +
                        "3-Principles of designing pipelined processors, Internal forwarding and register tagging, Hazard detection and resolution, Job\n" +
                        "sequencing and collision prevention, Concept of Array and Vector processing, Masking and Data routing: Concurrency in Pipelining\n" +
                        "and Vector Processing; Cache Coherence\n" +
                        "4 Lectures\n" +
                        "4-Case studies of vector processors, Array processors, Cube, Hypercube, Parallel algorithms on hyper cubes, Multiprocessor\n" +
                        "system, Multiprocessor interfacing schemes, Tightly & loosely coupled systems\n" +
                        "4 Lectures\n" +
                        "5-Shuffle exchange and Omega Network, VLIW Architecture; EPIC Architecture\n" +
                        "4 Lectures\n" +
                        "6- Concept of RISC systems; Data flow architectures; Comparison with control flow systems\n" +
                        "10 Lectures\n" +
                        "7-Introduction to Parallel Algorithms: Addition on Tree, Cube, Mesh, Linear Array , PSN, etc. Matrix multiplication on Mesh, Cube,\n" +
                        "Torus, etc.; Parallel Sorting; Associative Processing\n" +
                        "REFERENCES:\n" +
                        "1. Computer Architecture & Parallel processing – Hwang & Briggs\n" +
                        "2. Computer Architecture – Jean Loop Bear\n" +
                        "3. Introduction to Distributed and Parallel computing- Crichlow\n" +
                        "4. Designing Efficient Algorithms for parallel Computers- M.J.Quinn\n" +
                        "5. Introduction to Parallel Algorithms- Joseph JA\n" +
                        "6. The Design and Analysis of Parallel Algorithms- S.G.Akl\n" +
                        " 7. Computer Architecture & Organization – B Govindrajalu TMH\n";
            }
            else if (s2.equals("IV"))
            {
                syllabus = "Semester IV:\n" +
                        "1. .NET & C# (MCA-401)\n" +
                        "2. Multimedia Systems (MCA-402)\n" +
                        "3. Embedded Systems (MCA-403)\n" +
                        "4. Operation Research (MCA-404)\n" +
                        "5. Distributed Computing (MCA-405)\n" +
                        "6. Data Communication & Networks (MCA-406)\n" +
                        "Lab I : Programming in C#\n" +
                        "Lab II: Networks Lab.\n" +
                        "Lab.III: System Design Lab.\n" +
                        "Paper-1: NET FRAME WORK AND C# (MCA-401)\n" +
                        "8 Lectures\n" +
                        "1. The .NET framework: Introduction, Common Language Runtime, Common Type System, Common Language Specification,\n" +
                        "The Base Class Library, The .NET class library Intermediate language, Just-in-Time compilation, garbage collection,\n" +
                        "Application installation & Assemblies, Web Services, Unified classes.\n" +
                        "12 Lectures\n" +
                        "2. C# Basics: Introduction, Data Types, Identifiers, variables & constants, C# statements, Object Oriented Concept, Object and\n" +
                        "Classes, Arrays and Strings, System Collections, Delegates and Events, Indexes Attributes, versioning.\n" +
                        "6 Lectures\n" +
                        "3. C# Using Libraries: Namespace-System, Input Output, Multi-Threading, Networking and Sockets, Data Handling, Windows\n" +
                        "Forms,\n" +
                        "4 Lectures\n" +
                        "4. C# in Web application, Error Handling.\n" +
                        "10 Lectures\n" +
                        "5. Advanced Features Using C#: Web Services, Windows services, messaging, Reflection, COM and C#, Localization.\n" +
                        "Advanced Features Using C#: Distributed Application in C#, XML and C#, Unsafe Mode, Graphical Device Interface with C#,\n" +
                        "Case Study (Messenger Application)\n" +
                        "References:\n" +
                        "1. Jeffrey Richter, “Applied Microsoft .Net Framework Programming”, (Microsoft)\n" +
                        "2. Fergal Grimes, “Microsoft .Net for Programmers”, (SPD)\n" +
                        "3. TonyBaer, Jan D. Narkiewicz, Kent Tegels, Chandu Thota, Neil Whitlow, “Understanding the .Net Framework”, (SPD)\n" +
                        "4. Balagurusamy, “Programming with C#”, TMH\n" +
                        "Paper-2: MULTIMEDIA SYSTEMS (MCA-402)\n" +
                        "4 Lectures\n" +
                        "1. Multimedia Technology: Meaning & scope of Multimedia; Elements of Multimedia; Creating multimedia applications;\n" +
                        "Multimedia file & I/O functions; Multimedia data structures; Multimedia file formats; Multimedia Protocols\n" +
                        "7 Lectures\n" +
                        "2. Multimedia audio: Digital sound; Audio compression & decompression; Companding; ADPCM compression; MPEG audio\n" +
                        "compression; True Speech; Special effects and Digital Signal Processing; Audio synthesis; FM synthesis; Sound blaster\n" +
                        "card; Special effect processors on sound cards; Wave table synthesis; MIDI functions; Speech synthesis & Recognition\n" +
                        "7 Lectures\n" +
                        "3. Multimedia Video: Representation of Digital video; Video capture; Frame grabbing; Full motion video; Live video in a\n" +
                        "window; Video processor; Video compression & decompression; Standards for video compression & decompression;\n" +
                        "Playback acceleration methods\n" +
                        "7 Lectures\n" +
                        "4. Creating Multimedia Animation: Icon animation; Bit-map animation; Real-time vs Frame by Frame animation; Object\n" +
                        "modeling in 3D animation; Motion control in 3D animation; Transparency; Texture, Shadows, Anti-aliasing; Human\n" +
                        "modeling & Animation; Automatic motion control\n" +
                        "7 Lectures\n" +
                        "5. Multimedia Authoring tools: Project editor; Topic editor; Hot-spot editor; Developing a multimedia title; Multimedia text\n" +
                        "authoring systems; Usage of authoring tools\n" +
                        "5 Lectures\n" +
                        "6. Multimedia communication systems; Multimedia DBMS; Documents, Hypertext and MHEG; User Interfaces;\n" +
                        "Synchronization, A reference model for multimedia synchronization\n" +
                        "3 Lectures\n" +
                        "7. Multimedia on LANs & Internet: Multimedia on LAN; Fast modems & Digital networks for multimedia; High speed digital\n" +
                        "networks; Video conferencing techniques; Multimedia interactive applications on internet; Future Directions\n" +
                        "REFERENCES:\n" +
                        "1. Multimedia: Computing, Communications & Applications – Nahrstedt & Steinmetz\n" +
                        "2. Computer Speech Processing – Fallside F.\n" +
                        "3. Speech Analysis, Synthesis & Perception – Flanagan,J.L.\n" +
                        "4. Hypertext & Hypermedia- Nielsen J.\n" +
                        "5. Digital Processing of Speech Signala- Rabiner L.R. & Schafer L.W.\n" +
                        "2. EMBEDDED SYSTEMS (MCA-403)\n" +
                        "5 Lectures\n" +
                        "1. Classification of systems; Real-time design issues;Typical Real-time applications; Hard vs Soft real-time systems; A\n" +
                        "reference model for real-time systems; Design of data acquisition System; Language issues; Exception handling;\n" +
                        "Characteristics of real-time OS, Real-time kernels; Introduction to iRMX III+, TRON; Inter-task communication &\n" +
                        "synchronization; Real-time memory management; System performance issues & optimization\n" +
                        "4 Lectures\n" +
                        "2. Real-time specification & design techniques – Mathematical specification; Structure charts; Pseudo-code and\n" +
                        "programming design languages; DFDs, Petri Nets, State charts, Usage of Graphical Techniques\n" +
                        "5 Lectures\n" +
                        "3. Commonly used approaches to real-time scheduling- clock driven, priority driven; Priority driven scheduling of periodioc\n" +
                        "tasks, Scheduling aperiodic and sporadic jobs in priority driven systems; Resources and resource access control;\n" +
                        "Multiprocessor scheduling, resource access control & synchronization\n" +
                        "5 Lectures\n" +
                        "4. Real-time kernels: Polled loop systems; State driven code; Co-routines; Interrupt driven systems- Context Switching,\n" +
                        "Round Robin systems, Pre-emptive priority systems; Major & Minor processing; Foreground/Background systems; Full\n" +
                        "featured real-time OS\n" +
                        "5 Lectures\n" +
                        "5. Inter-task communication & Synchronization; Buffering data- Time-relative buffering, Ring Buffers; Mailboxes & their\n" +
                        "implementation, Other operation on Mailboxes; Queues; Critical regions; Semaphores- Counting Semaphores, Problems\n" +
                        "with semaphores; Deadlock- Detection & Recover, Avoidance\n" +
                        "3 Lectures\n" +
                        "6. Real-Time Memory Management- Process Stack Management; Dynamic Allocation; Static schemes\n" +
                        "5 Lectures\n" +
                        "7. System performance analysis & optimization: response-time calculation; Interrupt Latency; Time loading and its\n" +
                        "measurement; Reducing response times and time loading; Analysis of Memory requirements; Reducing Memory loading\n" +
                        "2 Lectures\n" +
                        "8. Comparative study of real-time programming languages\n" +
                        "6 Lectures\n" +
                        "9. Design of Embedded Systems – Techniques & issues involved\n" +
                        "REFERENCES:\n" +
                        "1. Automatic Control Systems - Kuo, B.C.\n" +
                        "2. Real-time Computer Control - Linkens & Bennett\n" +
                        "3. Real-time software for small systems - leigh, A.W.\n" +
                        "4. Programming embedded microprocessors - Fowler, R.J.\n" +
                        "5. Real-time systems Design & Analysis - Laplante P.A.\n" +
                        "Paper-4: OPERATIONAL RESEARCH (MCA-404)\n" +
                        "5 Lectures\n" +
                        "1. Network Analysis: Terminology of network, Shortest route problem, minimal spanning tree problem, max-flow problem.\n" +
                        "7 Lectures\n" +
                        "2. Project Scheduling by PERT, CPM: Diagram, representation, critical path calculation, construction of time chart and\n" +
                        "resource labeling, probability and cost consideration in project scheduling, project control.\n" +
                        "7 Lectures\n" +
                        "3. Linear Programming: Simplex Method, Revised simplex method, Duality in Linear programming, Application of Linear\n" +
                        "Programming to Economic and Industrial Problems.\n" +
                        "7 Lectures\n" +
                        "4. Nonlinear Programming: The Kuhn-Tucker conditions, Quadratic programming, Convex programming.\n" +
                        "7 Lectures\n" +
                        "5. Replacement Models: Introduction, Replacement policies for items whose efficiency deteriorates with time, Replacement\n" +
                        "policies for items that fail completely.\n" +
                        "7 Lectures\n" +
                        "6. Sequencing Model: Classification of self problems, processing of n jobs through two machines, three machines,\n" +
                        "processing of two jobs through m machines.\n" +
                        "REFERENCES:\n" +
                        "(1) Taha, Operations Research, Macmillan.\n" +
                        "(2) B.E. Gillet, Introduction to Operations Research, McGraw-Hill.\n" +
                        "(3) S.S.Rao, Optimization Theory and Applications, Wiley Eastern.\n" +
                        "(4) G.Hadley, Linear programming, Addison-Wesley.\n" +
                        "Paper-5: DISTRIBUTED COMPUTING (MCA-405)\n" +
                        "6 Lectures\n" +
                        "1.Introduction to Distributed Systems:\n" +
                        "Goals and advantages of distributed systems, Distributed Computing System Models, Network operating systems, True distributed systems,\n" +
                        "Design issues – Transparency, Reliability, Performance and Scalability\n" +
                        "5 Lectures\n" +
                        "2.Communication in Distributed Systems:\n" +
                        "Message Passing, Group communication. Remote procedure call (RPC), Light Weight RPC, Client Server Communication\n" +
                        "5 Lectures\n" +
                        "3.Distributed Shared Memory:\n" +
                        "Introduction to shared memory, Comparison of shared memory systems, Consistency models, Page-based distributed shared memory.\n" +
                        "6 Lectures\n" +
                        "4.Synchronization in Distributed Systems:\n" +
                        "Clock synchronization, Logical and physical clocks, Vector clock, Clock synchronization algorithms, Mutual exclusion – Centralized,\n" +
                        "Distributed, Token Ring and Maekawa’s Algorithm, Election Algorithms, Atomic transactions, Deadlocks in distributed systems.\n" +
                        "6 Lectures\n" +
                        "5.Processes and Processors in Distributed Systems:\n" +
                        "Process Migration, Threads – Usage, Design issues and implementation, Scheduling in distributed systems, Load balancing and Load sharing,\n" +
                        "Fault tolerance.\n" +
                        "5 Lectures\n" +
                        "6.Distributed File Systems:\n" +
                        "File Models, File Accessing Models, File Sharing Semantics,\n" +
                        "File Caching Schemes, File Replication\n" +
                        "5 Lectures\n" +
                        "7.Security in Distributed Systems:\n" +
                        "Potential Attacks to Computer Systems, Introduction to Cryptography, Authentication, Access Control\n" +
                        "2 Lectures\n" +
                        "\n" +
                        "8.Case Studies of Distributed Systems:\n" +
                        "V -Systems, Amoeba,\n" +
                        "References:\n" +
                        "1 Distributed Operating Systems: A.S.Tanenbaum\n" +
                        "2 Distributed Systems Concepts and Design: G.F.Coulouris, J.Dollimore and T.Kindberg\n" +
                        "3 Distributed Operating Systems: Pradeep K. Sinha\n" +
                        "Paper-6: DATA COMMUNICATION AND NETWORKS (MCA-406)\n" +
                        "5 Lectures\n" +
                        "1. History of Data Communication; Open System Standard; The electrical interface-transmission media, attenuation and\n" +
                        "distortion sources, signal types and signal propagation delay, public carrier service, physical layer interface standard\n" +
                        "5 Lectures\n" +
                        "2. Data Transmission basics-synchronous/asynchronous transmission; error detection method; data compression;\n" +
                        "transmission control circuits; communication control devices; protocol basics; data link control protocol\n" +
                        "5 Lectures\n" +
                        "3. Computer Networks: Lan-wired/wireless, protocols, Ethernet switching; fast Ethernet; FDDI; Bridges\n" +
                        "5 Lectures\n" +
                        "4. WAN-characteristic of public data networks; packet switched; circuit switched; ISDN; private networks\n" +
                        "5 Lectures\n" +
                        "5. Internetworking- inter network architecture issues, IP standards, ISO routing protocols\n" +
                        "5 Lectures\n" +
                        "6. Broad band multi service networks- networking requirement, FDDI II, Cell based networks, ATM Lans, DQDB, ATMR,\n" +
                        "CRMA II,\n" +
                        "5 Lectures\n" +
                        "7. Transport Protocols, Application support protocols, application specific protocols\n" +
                        "5 Lectures\n" +
                        "8. System aspects-layer interactions, implementation issues, related standards\n" +
                        "References:\n" +
                        "1. Data and Computer Communication- W.Stallings,\n" +
                        "2. Computer Networks- A.S.Tanenbaum\n" +
                        "3. Computer Network and Distributed Data Processing- J. Martin\n" +
                        "4. Local Networks - W.Stallings\n" +
                        "5. Computer Communication Network Design and Analysis- M.Schwertz\n" +
                        "6. Data Communications and Networking- B. A. Forouzan\n" +
                        "7. TCP/IP fundamentals-Vol I & II - Comer";
            }
            else if (s2.equals("V"))
            {
                syllabus = "Semester V:\n" +
                        "1. Image Processing (MCA-501)\n" +
                        "2. Information Retrieval and Web mining (MCA-502)\n" +
                        "3. Artificial Intelligence (MCA-503)\n" +
                        "4. Digital Communication (MCA-504)\n" +
                        "5. Secure Computing (MCA-505)\n" +
                        "Lab I: MINI PROJECT\n" +
                        "Lab II: Image Processing Lab.\n" +
                        "Paper-1: Image Processing (MCA-501)\n" +
                        "8 Lectures\n" +
                        "1. Introduction: Image representation and modeling, 2-D linear system, Luminance, Contrast and Brightness, Color\n" +
                        "representation, Visibility functions, Monochrome and color vision model.\n" +
                        "8 Lectures\n" +
                        "2. Image Quantization and Image Transforms: Sampling theorem, Anti-aliasing, image quantization, Orthogonal and\n" +
                        "unitary transforms, DFT, Cosine transform, Hadamard transform, Haar transform, KL transform.\n" +
                        "8 Lectures\n" +
                        "3. Image Enhancement: Point operation, Histogram modeling, Filtering and spatial operations, Transform operations,\n" +
                        "Multi-spectral Image Enhancement\n" +
                        "8 Lectures\n" +
                        "4. Image Restoration: Image formation models, Noise models, Inverse and Wiener filtering, Least square filters, Recursive\n" +
                        "filters, Maximum entropy method, Blind de-convolution, Bayesian method of noise removal, Image reconstruction,\n" +
                        "Tomography, Radan transform, Back-projection, Reconstruction algorithm, Algebraic method of reconstruction, Fanbeam\n" +
                        "reconstruction.\n" +
                        "8 Lectures\n" +
                        "5. Data Compression: Data compression vs. Bandwidth, Pixel coding, Predictive coding, Transform coding, Coding of twotone\n" +
                        "images.\n" +
                        "References:\n" +
                        "1. Fundamentals of Digital Image Processing: Anil K. Jain\n" +
                        "2. Digital Image Processing: R. Chellappa\n" +
                        "3. Image Processing for Scientific Applications: Bernd Jahne\n" +
                        "4. Digital Image Processing: R.C. Gonzalez & R.E. Woods\n" +
                        "5. The Image Processing Handbook: J.C. Russ\n" +
                        "6. Digital Image Processing: W.K. Pratt\n" +
                        "7. Digital Image Restoration: Andrews & Hunt\n" +
                        "2. Information Retrieval and Web mining (MCA- 502)\n" +
                        "5 Lectures\n" +
                        "Introduction:\n" +
                        "Introduction to information storage and retrieval, IR models, functional view of paradigm IR system, IR and other types of information systems.\n" +
                        "IR evaluation: Measuring effectiveness of IR system; Precision and recall, User centered evaluation.\n" +
                        "25 Lectures\n" +
                        "IR models:\n" +
                        "Boolean model, Vector space model, Probabilistic model, non-classical models of IR – Information logic model, cluster model, LSI model; AI in\n" +
                        "IR – ANN model, genetic algorithm model, Knowledge-bases, Natural language processing; Query expansion.\n" +
                        "Data structures and algorithms related to IR : Data structures -inverted files and its implementation, B-trees and tries, signature files;\n" +
                        "algorithms – indexing and retrieval algorithms.\n" +
                        "Term and query operation\n" +
                        "Tokenization, stop lists, stemming, different types of stemmers; thesaurus construction; query modification .\n" +
                        "Vector space model\n" +
                        "Indexing - document and query representation; Term weighting; Similarity measures, ranking algorithms; Query expansion- Relevance feedback\n" +
                        "methodology Rocchio’s and Ide’s method, Evaluation of relevance feedback; clustering algorithms and its application.\n" +
                        "10 Lectures\n" +
                        "Further topics:\n" +
                        "Web information indexing; Web Information categorization and ranking; Web IR evaluation; Data fusion, Text mining; Semantic Web;\n" +
                        "Intelligent agents in IR.\n" +
                        "References:\n" +
                        "1. Modern Information Retrieval, Ricardo – Baeza Yates, B. Ribeiro-Neto (Addison Wesley Longman)\n" +
                        "2. C. J. van Rijsbergen “Information Retrieval”, Second Edition\n" +
                        "3. G. Salton, and M. J. McGill, “Introduction to modern information retrieval”. New York: McGraw-Hill\n" +
                        "4. Information Retrieval: Data Structures and algorithms. W. Frakes and R. Baeza-Yates (Eds.). Prentice Hall\n" +
                        "5. D. Jufrasky, and J. H. Martin. “Speech and language processing: an introduction to natural language processing, computational linguistics, and\n" +
                        "speech recognition”. Pearson education, Asia, 2000.\n" +
                        "6. Introduction to Information Retrieval, by C. Manning, P. Raghavan, and H. Schütze\n" +
                        "Paper-3: ARTIFICAL INTELLIGENCE (MCA-503)\n" +
                        "10 Lectures\n" +
                        "Introduction:\n" +
                        "What is AI?; Scope of AI: Games, theorem proving, Natural language processing, Vision and speech processing, Robotics & Expert systems,\n" +
                        "AI techniques, Introduction to intelligent agents.\n" +
                        "12 Lectures\n" +
                        "Search Techniques:\n" +
                        "State space search, control strategies: Depth first search, Breadth first search and Production systems; Use of heuristics: Hill climbing, Best first\n" +
                        "search, A* algorithm- admissibility, AND/OR graph – AO*, Constraint satisfaction; Game playing: Minimax and Alpha-Beta searching, Genetic\n" +
                        "algorithms.\n" +
                        "12 Lectures\n" +
                        "Knowledge Representation:\n" +
                        "Propositional logic: its syntax and semantics; Reasoning patterns in propositional logic: Resolution, forward and backward reasoning.\n" +
                        "First order logic: Syntax and semantics; Inference in first order logic: Unification, Forward & backward chaining, Resolution.\n" +
                        "Structured knowledge representation: Semantic Net, Frames, and Conceptual graphs.\n" +
                        "Uncertain knowledge and reasoning: Introduction to probabilistic reasoning; representing vagueness- fuzzy sets and fuzzy logic.\n" +
                        "6 Lectures\n" +
                        "Learning:\n" +
                        "Different forms of learning; Concept learning system; Inductive learning; Learning decision trees; Neural network: single layer feed forward\n" +
                        "network.\n" +
                        "References:\n" +
                        "1 Artificial Intelligence: Rich and Knight\n" +
                        "2 Artificial Intelligence: A Modern Approach: Stuart Russell and Peter Norvig\n" +
                        "3 Introduction to Artificial Intelligence: Partick Winston\n" +
                        "4 Artificial Intelligence: Nilsson\n" +
                        "Paper-4:DIGITAL COMMUNICATION (MCA-504)\n" +
                        "10 Lectures\n" +
                        "Pulse Code Modulation:\n" +
                        "Basic elements of a PCM System, Quantization Electrical representation of binary digits. Companding. Multiplexing of PCM signals,\n" +
                        "Digital Hierarchy, Pulse stuffing, differential PCM. Delta Modulation. Adaptive delta modulation, Comparison of ADM & DM.\n" +
                        "10 Lectures\n" +
                        "Digital Modulation Techniques: Power density of digital data BPSK, OOK, BFSK, DPSK, M-ary ASK, Quadrature phase shift\n" +
                        "keying Duo binary encoding.\n" +
                        "10 Lectures\n" +
                        "Modulation and Demodulation in Presence of Additive White Gaussian Noise:\n" +
                        "A baseband receiver, optimum filter, matched filter, Different representation of narrow band signals and systems. Spectrum of\n" +
                        "digital modulated signals, Calculation of probability of error for binary & M-ary signals, digital signaling schemes for coherent and\n" +
                        "non-coherent demodulation. Comparison of different modulation schemes, Symbol synchronization and carrier recovery circuits.\n" +
                        "10 Lectures\n" +
                        "Digital Signaling in Presence of ISI & A WGN:\n" +
                        "Design of band limited channels for no IS I, Design of band limited signals for controlled .ISI (partial response signals), Optimum\n" +
                        "demodulator in presence of IS I & A WGN noise.\n" +
                        "Reference:\n" +
                        "1. Principles of Communication Taube Schilling (TMH)\n" +
                        "2. Digital Communication J.G. Proakis (TMH)\n" +
                        "3. Digital Communication S.Haykin (Wiley)\n" +
                        "Paper-5: SECURE COMPUTING (MCA-505)\n" +
                        "5 Lectures\n" +
                        "Basics of computer security\n" +
                        "Kinds of security branches, Security goals and vulnerabilities, Methods of Defence\n" +
                        "15 Lectures\n" +
                        "Program Security\n" +
                        "Viruses and other malicious codes, Targeted malicious codes, Controls against program threats; Protection in General\n" +
                        "purpose operating systems, Protecting memory and addressing, Protecting access to general objects, File protection\n" +
                        "mechanisms, User authentication\n" +
                        "6 Lectures\n" +
                        "Security in Networks and Distributed Systems\n" +
                        "Threats in Network, Network security control, Administering Security\n" +
                        "10 Lectures\n" +
                        "Encryption and Decryption\n" +
                        "Mono alphabetic substitution ciphers, Poly alphabetic substitution ciphers, Transpositions, Stream and block ciphers,\n" +
                        "Secure encryption system: Public key Encryption, Merkel Hellman, knapsacks, RSA Encryption, EL Gamel algorithm, Hash\n" +
                        "Algorithms, Digital Signature algorithm, Symmetric system, DES algorithm, Enhancing cryptographic security.\n" +
                        "Legal and Ethical issues in Computer Security 4 Lectures\n" +
                        "Protecting programs and data, computer crime, Ethical issues, Electronic privacy\n" +
                        "References:\n" +
                        "1. Security in computing Charles P.Pfleeger (Prentice Hall)\n" +
                        "2. Computer Security Handbook Vol 1 & 2 Bosworth, Kabay & Whyne (Wiley)\n" +
                        "3. Applied cryptography Schneier, Bruce (Wiley)\n" +
                        "4. Practical cryptography Schneier & Ferguson (Wiley)\n" +
                        "5. Introduction to cryptography: Principles";
            }
            else
            {
                syllabus = "Semester VI:\n" +
                        "1. Mobile Computing and Applications (MCA-601)\n" +
                        "2. Elective: Cloud Computing, E-commerce & Cyber laws/ High Performance\n" +
                        "Computing/Human Computer Interaction/ Application Development on Hand-held\n" +
                        "devices/ Computer Animation/Natural Language Processing/Computer Vision/Artificial\n" +
                        "Neural Networks/Fuzzy Systems (MCA-602)\n" +
                        "Paper-1: MOBILE COMPUTING AND APPLICATIONS (MCA-601)\n" +
                        "5 Lectures\n" +
                        "1. Introduction: Evolution and fundamentals of Mobile communication, Terminal mobility, Personal Mobility and Service\n" +
                        "Portability, The Cellular concept, A basic cellular system, Multiple access technologies of cellular systems, Analog &\n" +
                        "Digital cellular systems, Generations of systems, Cellular system operation and planning, System architecture, Location\n" +
                        "updating and call setup, Handoff & power control\n" +
                        " 10 Lectures\n" +
                        "2. Digital cellular systems: Evolution of Mobile System, GSM, GSM standardization and service aspects, GSM reference\n" +
                        "architecture and function partitioning, GSM radio aspects, GSM security aspects, GSM protocol model, GSM call flow\n" +
                        "sequences, gprs, edge; (Wireless) Medium Access Control: Motivation for a specialized MAC(Hidden and exposed\n" +
                        "terminals, Near and Far terminals), SDMA, FDMA, TDMA, CDMA\n" +
                        " 6 Lectures\n" +
                        "3. Mobile network layer: Mobile IP: goals, assumptions, entities and terminology, IP packet delivery, agent advertisement and\n" +
                        "discovery, registration, tunneling and encapsulation, optimizations, Dynamic Host Configuration Protocol (DHCP).\n" +
                        " 6 Lectures\n" +
                        "4. Mobile Transport Layer: Traditional TCP ,Indirect TCP ,Snooping TCP ,Mobile TCP, Fast retransmit/fast recovery\n" +
                        ",Transmission /time-out freezing ,Selective retransmission, Transaction oriented TCP\n" +
                        "8 Lectures\n" +
                        "5. Database issues: Hoarding techniques, caching invalidation mechanisms. client server computing with adapt ion , poweraware\n" +
                        "and context-aware computing, transactional models, query processing, recovery, and quality of service issues\n" +
                        " 5 Lectures\n" +
                        "6. Mobile Ad hoc Networks (MANETs): Overview, Properties of a MANET, spectrum of MANET, applications, routing and\n" +
                        "various routing algorithms, security in MANET’s.\n" +
                        "REFERENCES:\n" +
                        "1. Mobile and Personal communication systems and Services – Raj Pandya\n" +
                        "2. Mobile Communications – Schiller J.\n" +
                        "3. Mobile Cellular Telecommunications – Lee William C.Y.\n" +
                        "4. Wireless Communications & Networks – Stallings, William\n" +
                        "2. Elective: Cloud Computing, E-commerce & Cyber laws/ High Performance Computing/Human Computer Interaction/\n" +
                        "Application Development on Hand-held devices/ Computer Animation/Natural Language Processing/Computer\n" +
                        "Vision/Artificial Neural Networks/Fuzzy Systems (MCA-602)\n" +
                        "E-COMMERCE & CYBER LAWS\n" +
                        "5 Lectures\n" +
                        "1. Introduction: Electronic Commerce - Technology and Prospects, Definition of E- Commerce, Economic potential of\n" +
                        "electronic commerce, Incentives for engaging in electronic commerce, forces behind E-Commerce, Advantages and\n" +
                        "Disadvantages, Architectural framework, Impact of E-commerce on business.\n" +
                        "6 Lectures\n" +
                        "2. Network Infrastructure for E- Commerce: Internet and Intranet based E-commerce- Issues, problems and prospects,\n" +
                        "Network Infrastructure, Network Access Equipments, Broadband telecommunication (ATM, ISDN, FRAME RELAY).\n" +
                        "5 Lectures\n" +
                        "3. Mobile Commerce: Introduction, Wireless Application Protocol, WAP technology, Mobile Information device, Mobile\n" +
                        "Computing Applications.\n" +
                        "5 Lectures\n" +
                        "4. Web Security: Security Issues on web, Importance of Firewall, components of Firewall, Transaction security, Emerging\n" +
                        "client server, Security Threats, Network Security, Factors to consider in Firewall design, Limitation of Firewalls.\n" +
                        "8 Lectures\n" +
                        "5. Encryption: Encryption techniques, Symmetric Encryption- Keys and data encryption standard, Triple encryption,\n" +
                        "Asymmetric encryption- Secret key encryption, public and private pair key encryption, Digital Signatures, Virtual Private\n" +
                        "Network.\n" +
                        "5 Lectures\n" +
                        "6. Electronic Payments: Overview, The SET protocol, Payment Gateway, certificate, digital Tokens, Smart card, credit\n" +
                        "card, magnetic strip card, E-Checks, Credit/Debit card based EPS, online Banking. EDI Application in business, ECommerce\n" +
                        "Law, Forms of Agreement, Govt. policies and Agenda.\n" +
                        "6 Lectures\n" +
                        "7. Cyber Laws\n" +
                        "References\n" +
                        "1. Ravi Kalakota, Andrew Winston, “Frontiers of Electronic Commerce”, Addison Wesley.\n" +
                        "2. Bajaj and Nag, “E-Commerce the cutting edge of Business”, TMH\n" +
                        "3. P. Loshin, John Vacca, “Electronic commerce”, Firewall Media, New Delhi\n" +
                        "HIGH PERFORMANCE COMPUTING\n" +
                        "5 Lectures\n" +
                        "Introduction:\n" +
                        "Motivation for high performance and parallelism application areas, Technologies, Abstraction levels, Models of Computation; Overheads,\n" +
                        "Multiple program counters, Multi-threaded execution models; Parallel languages and compilers, Task Parallel and Data parallel Programming\n" +
                        "models; Memory architecture; Memory access times and associated overheads; Performance timing; Restructuring for parallel performance;\n" +
                        "Parallelising compilers; Load & Data transformation; State of the art research & future direction\n" +
                        "5 Lectures\n" +
                        "Microprocessor and system architecture:\n" +
                        "Pipelining, superscalar designs; SIMD, multithreading; caches; memory, busses; Asynchronous microprocessors for high performance\n" +
                        "processing and low power applications\n" +
                        "5 Lectures\n" +
                        "Multi processor architectures:\n" +
                        "Classification; programming models; application examples; interconnection networks\n" +
                        "5 Lectures\n" +
                        "Tightly coupled systems:\n" +
                        "Cache coherence, consistency, synchronization; SMP, ccNUMA, COMA; performance evaluations\n" +
                        "20 Lectures\n" +
                        "Other architectures and extensions:\n" +
                        "Distributed memory systems; vector systems; clusters, grids\n" +
                        "Supercomputer Architecture; Vector Machines; Parallel Processors; Data Parallel Processors. Single-Instruction-Multiple-Data; MultipleInstruction-Multiple-Data;\n" +
                        "Pipelining; Vectorization; Parallelization; Superscalar execution – VLIW computation; PRAMs – parallelism issues\n" +
                        "Comparison of Serial, Parallel and Vector Architectures.\n" +
                        "Performance Measures and Models; Speed-up limitations; Theoretical Timings; Efficiencies; Amdahl's Law and Extensions; Scaled Speed-up;\n" +
                        "Pipeline Speed-up.\n" +
                        "Data Dependency Reduction. Data flow; Loop reordering.\n" +
                        "Parallelization of Algorithms; Parallel linear algebra routines; Loop optimizations; Implementation; Principle of Locality; Caches and Buffers.\n" +
                        "References:\n" +
                        "1. J. J. Dongarra, I. B. Duff, D. C. Sorensen and H. A. van der Vorst: Solving Linear Systems on Vector and Shared Memory Computers,\n" +
                        "SIAM, 1991.\n" +
                        "2. K. Hwang: Advanced Computer Architecture: Parallelism, Scalability, Programmability, McGraw-Hill\n" +
                        "3. D. A. Patterson and J. L. Hennessy, Computer Architecture: A Quantitative Approach, Morgan Kaufmann\n" +
                        "4. D. Kuck: The Structure of Computers and Computations, Wiley\n" +
                        "5. Levesque and Williamson: A Guidebook to FORTRAN on Supercomputers, Academic Press\n" +
                        "6. Metcalf: FORTRAN Optimization, Academic Press\n" +
                        "7. J. M. Ortega: Introduction to Parallel and Vector Solution of Linear Systems, Plenum\n" +
                        "8. Quinn: Designing Efficient Algorithms for Parallel Computers, McGraw-Hill\n" +
                        "9. P. J. Hatcher and M. J. Quinn: Data-Parallel Programming on MIMD Computers, MIT Press\n" +
                        "10. Parallel processor architecture & VLSI Hardware: Decegama A.L.\n" +
                        "11. Introduction to Parallel Algorithms & Architectures – Arrays, Trees and Hypercubes: Leighton F. Thomson\n" +
                        "Computer Vision\n" +
                        "5 Lectures\n" +
                        "Images:\n" +
                        "Sources of imagery, The physics of imaging, Representing, acquiring, and displaying images, Grayscale, color, noise, lens distortion, and\n" +
                        "filtering\n" +
                        "5 Lectures\n" +
                        "Image processing: \n" +
                        "Preprocessing, and image correction, Enhancing features and correcting imperfections, Addressing noise, lens distortion, and blurring.\n" +
                        "5 Lectures\n" +
                        "Computer Vision Paradigms:\n" +
                        "Bottom-up, top-down, neural net, feedback, Pixels, lines, boundaries, regions, and object representations, \"Low-level\", \"intermediate-level\", and\n" +
                        "\"high-level\" vision, Historical and illustrative examples.\n" +
                        "5 Lectures\n" +
                        "Finding Edges and Lines:\n" +
                        "Finding edges (low-level), Gradients, zero crossing detectors, line models, Roberts, Sobel, Cany, Finding and grouping lines (intermediatelevel),\n" +
                        "Boundary tracing, line fitting, Hough transform.\n" +
                        "15 Lectures\n" +
                        "Finding and Processing Regions:\n" +
                        "Finding \"elementary regions\" (low-level), Merging, splitting, and grouping regions (intermediate-level)\n" +
                        "Grouping and analyzing lines and regions (high-level), Guzman, Clowes and Huffman, Waltz.\n" +
                        "Stereo, and Motion, Optical Flow and FOE, Motion Understanding\n" +
                        "Texture, Fourier transform\n" +
                        "Representing the environment and Matching, Clouds, generalized cylinders, semantic nets, Matching line and region groups to object\n" +
                        "representations (high-level).\n" +
                        "5 Lectures\n" +
                        "Applications:\n" +
                        "Using computer vision, Applications in Medicine, Industry, and Surveillance\n" +
                        "References:\n" +
                        "1. Digital Image Processing - R.C.Gonzalez & P.Wintz\n" +
                        "2. Computer Vision - D.H.Ballard & C.M.Brown\n" +
                        "3. Syntactic Pattern Recognition: An introduction -R.C.Gonzalez and M.G.Thomason\n" +
                        "4. Pattern Recognition - A Statistical Approach - P.A. Devijver and J. Kittler\n" +
                        "5. Digital Image Processing - W. K. Pratt\n" +
                        "6. Fundamentals of Digital Image Processing - A.K. Jain\n" +
                        "7 Digital Picture Processing - A. Rosenfeld and A.C. Kak\n" +
                        "8. Vision in Man and Machine - M.D. Levine\n" +
                        "Artificial Neural Networks\n" +
                        "5 Lectures\n" +
                        "Introduction:\n" +
                        "Real and artificial neural networks, Neurons as Processing elements, Activation and Signals, Threshold functions, Connection topologies.\n" +
                        "15 Lectures\n" +
                        "Network Models:\n" +
                        "Dynamical Systems viewpoint, Additive dynamics, Additive neuronal feedback, Bivalent additive associative memory, Stability of BAMs,\n" +
                        "Lyapunov functions, Bivalent BAM theorem, BAM connection matrices, Linear associative memory, Optimal linear associative memory,\n" +
                        "Memory capacity, Hopfield model,\n" +
                        "Additive dynamics and Noise-Saturation dilemma, Grossberg’s saturation theorem, Multiplicative dynamics, Shunting inhibition, Adaptive\n" +
                        "resonance theory of Grossberg, ART1 and ART2 networks.\n" +
                        "20 Lectures\n" +
                        "Network Learning Methods:\n" +
                        "Unsupervised learning, Learning laws, Signal Hebbian, Competitive, Differential Hebbian and differential competitive learning laws,\n" +
                        "Deterministic and stochastic learning, Stochastic equilibrium, Asymptotic centroid estimation, Kohonen’s self-organizing map, Reinforcement\n" +
                        "learning.\n" +
                        "Supervised learning, Stochastic approximation, Perceptron learning theorem, LMS algorithm, Back-propagation algorithm, Multilayer feedforward\n" +
                        "networks, Enhancements in Back-propagation algorithm., Recurrent back-propagation.\n" +
                        "Adaptive vector quantization, AVQ algorithms, Convergence theorem, Adaptive bi-directional associative memory.\n" +
                        "References:\n" +
                        "1. Neural Networks and Fuzzy Systems: Bart Kosko\n" +
                        "2. Neural Computing: Theory and Practice: P.D.Wasserman\n" +
                        "3. Artificial Neural systems: P.K.Simpson\n" +
                        "4. Neurocomputing: Robert Hecht-Nielson\n" +
                        "5. Neural Networks: J.A.Freeman\n" +
                        "Fuzzy Systems\n" +
                        "8 Lectures\n" +
                        "Fuzzy Set Concepts\n" +
                        "Fuzzy and crisp sets, Operations on Fuzzy sets, Extended Fuzzy sets, Fuzzy quantifiers and its relation to linguistic variables,\n" +
                        "members function and its estimation, binary and n-ary fuzzy relations, fuzzy graphs and matrices.\n" +
                        "8 Lectures\n" +
                        "Fuzzy Measure\n" +
                        "Belief and plausibility measures, probability measure, possibility measures,\n" +
                        "8 Lectures\n" +
                        "Theory of Approximate reasoning and uncertainty measurement\n" +
                        "Multivalent logic and fuzzy valued logic, fuzzy model logic, approximate reasoning, fuzzy algebra and uncertainty, classical and\n" +
                        "fuzzy measures of uncertainty\n" +
                        "8 Lectures\n" +
                        "Fuzzy Systems\n" +
                        "General fuzzy systems and its design, fuzzy control systems with applications, fuzzy optimization, fuzzy expert and decision\n" +
                        "Making systems, probabilistic search trees, fuzzy pattern analysis, fuzzy database search, some applications\n" +
                        "8 Lectures\n" +
                        "Fuzzy Programming and Tools\n" +
                        "Fuzzy Programming environments, efficiency and accuracy, fuzzy tools, learning fuzzy rules in neural networks, fuzzy associative\n" +
                        "mapping, introduction to neuro-fuzzy and fuzzy genetic approaches.\n" +
                        "Reference:\n" +
                        "1. Fuzzy mathematical techniques with application: Abraham Kandel\n" +
                        "2. Fuzzy Sets, Uncertainty and information: G.J. Klir and T.A. Folger\n" +
                        "3. Fuzzy Systems: C.v. Negotia\n" +
                        "4. Neural Networks and Fuzzy Systems: B. Kosko\n" +
                        "Application Development on Hand Held Device\n" +
                        "Introduction To Application Development for Handheld 6 Lectures\n" +
                        "Features, Device Types, Device Limitations, Technology & marketing trends, Mobile Applications and its Types, Mobile web sites,\n" +
                        "Apps,Web apps and Native Apps, Introduction to Mobile Web design, Design Time and Runtime Considerations\n" +
                        "Website Design For Smart Devices 8 Lectures\n" +
                        "HTML5, Javascrip, Jquery Programming, Jquery Selectors, Event Binding, Animation, Ajax, CSS3 Features for web, borderradius,\n" +
                        "gradients, box-sizing, min-width, max-width, box-shadow, text-shadow, text-overflow, multiple-backgrounds, Understanding\n" +
                        "CSS Animations, Using CSS Transitions, Css Media Queries, Role of Mordenizer. Js, Responsive Website Design and\n" +
                        "Development, Firebug Extension, Layout Frameworks, Using Skeleton.js\n" +
                        "Web Apps 10 Lectures\n" +
                        "Jquery Mobile, Introduction, Data Attributes, Pages, Dialog, Toolbars, Navbars, Theming, Transitions, Ajax, Events, Touch, Swap,\n" +
                        "Tap, Slide, Offline Cache, Customizing Themes, Deployment\n" +
                        "Development on Android 16 Lectures\n" +
                        "Web App as Native … Android Introduction, Developer Tools, Platform Tools, ADB, AVD, Phonegap/Cordova Introduction,\n" +
                        "Development Environment, CLI and Build, Converion to Native for platforms (android/windows/ios etc.), Deployment, Geolocation,\n" +
                        "Device Rotation, Device Orientation, Touch gestures, Offline Apps, Client Side storage, Testing and Deployment on virtual and\n" +
                        "physical devices.\n" +
                        "Native App … Android Studio, Getting Started with IDE, Development, Debugging and Deployment, Programming Model and\n" +
                        "Structure, APIs and Packages, Accessing native services of OS, Testing and Deployment on virtual and physical device\n" +
                        "\n" +
                        "Reference:\n" +
                        "1. Build Mobile Websites And Apps for Smart Devices by E. Castledine\n" +
                        "2. Jump Start Responsive Web Design by Craig Sharkie & Andrew Fisher\n" +
                        "3. O’REILLY Building Android Apps with HTML, CSS and Javascript\n" +
                        "4. Building Windows 8 Application Development – XAML edition by Kyle Burns\n" +
                        "5. Beginning Android 4 Application Development by Wei-Meng Lee\n" +
                        "6. O’REILLY Building iPhone Apps with HTML, CSS and Javascript by Jonathan Stark";
            }
        }
        else if(s1.equals("BCA"))
        {
            if(s2.equals("I"))
             {
                 syllabus = "Paper-I Mathematics-I (BCA-101)\n" +
                         "Linear Algebra 16 Lectures\n" +
                         "Basis and Dimension, Linear transformations and their matrix representations, Matrix algebra, Rank of matrix, Echelon and normal\n" +
                         "form, Linear systems of algebraic equations, Consistency, Gauss elimination method, Homogeneous and non-homogeneous\n" +
                         "systems of equations, Inverse of matrices, Determinants, Characteristics polynomial, Eigen values and eigenvectors, CayleyHamilton\n" +
                         "theorem, Eigenvalues of Hermitian unitary matrices.\n" +
                         "Calculus 12 Lectures\n" +
                         "Limit, Continuity & differentiability of functions of one variable, Mean-value Theorems, Rolle’s Theorem, Leibnitz formula for nth\n" +
                         "derivatives of products of functions, Taylor and Maclaurin Theorems, Maxima, Minima and Tangent plane, Tangent lines and\n" +
                         "normals, Theorems of integral calculus, Evaluation of definite & improper integrals, Introduction to Functions of several variables:\n" +
                         "Partial differentiation, Change of variables in partial differentiation.\n" +
                         "Ordinary Linear Differential Equations 12 Lectures\n" +
                         "Ordinary differential equations of first order, Separable, exact & linear equations, Existence and uniqueness theorems (Statement\n" +
                         "only), Higher order linear equations, Wronskians Method of variation of parameters for particular solutions, Euler’s and Cauchy’s\n" +
                         "equations, Systems of first order equations with constant coefficients\n" +
                         "References:\n" +
                         "1. Advanced Engineering Mathematics, Erwin Kreyszig\n" +
                         "2. Calculus: Volume I, Aposto\n" +
                         "3. Calculus and Analytical Geometry, G.B. Thomas & Finney\n" +
                         "4. A Course in Ordinary Differential Equations, Rai, Chaudhary & Friedman\n" +
                         "5. Higher Engineering Mathematics, B S Grewal\n" +
                         "6. Mathematical Methods, Potter and Goldberg\n" +
                         "7. Matrix Theory, David Lewis\n" +
                         "Paper-II Statistics (BCA-102)\n" +
                         "Probability & Distribution Theory 20 Lectures\n" +
                         "Random Experiments, Sample space, Events, Definitions of probability, Probability of union of events, Conditional Probability,\n" +
                         "Bayes’ theorem, Independence of events,\n" +
                         "Random Variables, Distribution functions, Probability Mass Function (PMF) of Discrete Random Variables, Probability Density\n" +
                         "Function (PDF) of continuous random variables, Mathematical expectation, Moments\n" +
                         "Discrete uniform distributions, Bernoulli distribution, Poisson distribution, Binomial distribution, Continuous uniform distribution,\n" +
                         "Normal distribution, Exponential distribution, Reliability function and instantaneous failure rate for exponential distribution\n" +
                         "Statistical Methods and Statistical Inferences 20 Lectures\n" +
                         "Measures of Central Tendency, Dispersion, Simple linear regression, Method of least squares, Correlation Coefficients\n" +
                         "Point and interval estimation, Unbiased, sufficiency, likelihood function and maximum likelihood estimator, Confidence interval for\n" +
                         "the mean of normal distribution\n" +
                         "Sampling distributions: χ2 , t and F distributions, Basic concept of testing of hypothesis, Role of p-value, Standard tests based on\n" +
                         "χ2 , t and F distributions\n" +
                         "References:\n" +
                         "1. Fourier series and Boundary Value Problems, Churchill R.V. (McGraw Hill)\n" +
                         "2. Probability and Statistics for Engineers, Irvrin Miller & Friend (Prentice Hall of India)\n" +
                         "3. Engineering Statistics, Bowker and Lieberman (Prentice Hall of India)\n" +
                         "4. Introductory Statistics and Probability for Engineering Science and Technology, Kirk – Patrick (PHI)\n" +
                         "5. Modern Probability Theory and its Applications, Parzen E. (Wiley Eastern)\n" +
                         "Paper-III Basic Electronics (BCA-103)\n" +
                         "Semiconductors and PN Junction Diode 12 Lectures\n" +
                         "Properties of semiconductors, Intrinsic and extrinsic semiconductors, P and N type of impurities and doping, Charge densities and\n" +
                         "potential barrier, Draft and diffusion currents, PN junction working and characteristics, It’s applications as – Rectifier: Half wave, Full\n" +
                         "wave, Bridge Rectifier and their calculation for ripple, Efficiency and PIV; Clipper, Clamper and voltage doublers, Zener and\n" +
                         "Avalanch breakdown diodes, Tunnel diode, Varacter diode, Thermister\n" +
                         "Page 3 of 16\n" +
                         "Bipolar Transistor 8 Lectures\n" +
                         "Transistor action with simple bias conditions, Working and basic characteristics, CB, CE & CC configuration of transistor amplifiers,\n" +
                         "Analysis for CB and CE basic amplifiers- Determination of Q-point, dc load line and calculations for gains and impedances, Effect of\n" +
                         "load and ac load line\n" +
                         "Transistor biasing 8 Lectures\n" +
                         "Biasing circuits for CB and CE configurations, Leakage currents in CB & CE and it’s effect, Thermal stabilization & Stability factor,\n" +
                         "Different biasing arrangements for CE- their advantages and drawbacks, Transistor thermal power dissipation and rating\n" +
                         "Equivalent Circuits of Transistor 7 Lectures\n" +
                         "Transistor as four port device, Impedance, Z-parameters and circuits representation, Admittance Y parameters and circuit\n" +
                         "representation, h-parameters and circuit representation; Analysis of CB and CE circuits using h-parameters for gains and\n" +
                         "impedances\n" +
                         "Field Effect Transistors 5 Lectures\n" +
                         "Basic configuration of JFET, Biasing, Principle of operation and basic characteristics, Basics of MOSFET\n" +
                         "References:\n" +
                         "1. Electronic Devices and Circuits, Allen Motersheid\n" +
                         "2. Integrated Electronics, Jacob Millman\n" +
                         "3. Electronic Devices and Circuit Theory, L. Boylestad and Nashelsky\n" +
                         "4. Handbook of Electronics, Gupta and Kumar\n" +
                         "Paper-IV Fundamentals of Programming (BCA-104)\n" +
                         "Algorithm development and C language Programming 10 Lectures\n" +
                         "Structure and properties of algorithm, Flow chart, Algorithms for g.c.d., Factorial, Fibonacci series, Prime number generation and\n" +
                         "other simple problems, searching & sorting techniques\n" +
                         "Programming in C : History, Introduction to C, Structure of C programs, Compilation & execution of C programs, Debugging\n" +
                         "techniques, Data types & sizes, Declaration of variables, Modifiers, Identifiers & keywords, Symbolic constants\n" +
                         "C Language Features 30 Lectures\n" +
                         "Operators: Unary operators, Arithmetic & Logical operators, Bit-wise operators, Assignment operators and expressions, Conditional\n" +
                         "expressions, Precedence & order of evaluation;Control statements: If-else, Switch, Break, Continue, Comma operator, Go-to\n" +
                         "statement;Loops: For, While, Do-while;Functions: Built-in & User-defined, Function declaration, Definition & function call, Parameter\n" +
                         "passing: Call by value, Call by reference, Recursive functions, Multi-file programs, Command line parameters;Arrays: Linear arrays,\n" +
                         "Multi-dimensional arrays, Passing arrays to functions, Arrays & Strings;Storage classes: Automatic, External, Register & Static,\n" +
                         "Enumerations; C Directives: Macros, C pre-processor;Structures & Union: Definition and differences, Self-referential structure;\n" +
                         "Pointers: Value at (*) and address of (&) operator, Pointer to pointer, Dynamic memory allocation, Calloc & Malloc functions, Array\n" +
                         "of pointers, Function of pointers, Structures and pointers, Linked list: Single, Double, Circular; File Handling in C: Opening, Closing\n" +
                         "and creating a data file, Read and Write functions, Unformatted data files\n" +
                         "References:\n" +
                         "1. The C Programming Language, B.W. Kernighan and D.M. Ritchie (PHI)\n" +
                         "2. Programming using the C language, R.C. Hutchinson and S.B. Just (McGraw Hill)\n" +
                         "3. Outline of Theory and Problems of Programming with C, B.S. Gottfried (Schaum McGraw Hill)\n" +
                         "4. C: The Complete Reference, H. Schildt (McGraw Hill)\n" +
                         "Paper-V Communication Skills (BCA-105)\n" +
                         "Introduction to Communication 10 Lectures\n" +
                         "Importance of communication, Communication in primitive societies, Verbal and non-verbal, One way and two way communication,\n" +
                         "Objectives of communication: Information, Advice, Order, suggestion, Persuasion, Education, Warning, Raising morale, Motivation,\n" +
                         "Mass communication, Written and oral communication, Visual communication, Audio-visual communication, Role of news papers,\n" +
                         "Radio, Cinema and TV, Principles of communication: Clarity, Completeness, Conciseness, Consideration, Courtesy, Correctness,\n" +
                         "Choice of the right word, The art of listening- learning through listening- body language\n" +
                         "Types of Communication 10 Lectures\n" +
                         "Official and business communication, Process of communication, Downward, Upward and horizontal communication, Essential of\n" +
                         "good communication, Level of communication- inter and intra personal, group to person, group to group, Methods of effective oral,\n" +
                         "Written and non-verbal communication, Horizons-tone, frequency, rate, volume, depth, Barrier to communication and over coming\n" +
                         "barriers, Listening skill, Use of audio visual aids for effective communication\n" +
                         "Comprehension 10 Lectures\n" +
                         "Comprehension of ideas in a passage, Expansion of an idea for a particular purpose, Summarizing a passage for official usage,\n" +
                         "Communication a given idea to suit different contexts, Report writing- importance of reports, preparing a report, technical report\n" +
                         "writing\n" +
                         "Communication Aids 10 Lectures\n" +
                         "Prose Text Book, Precis writing, Grammar, Words, Idioms, Antonyms and synonyms, Using Microsoft Office Suite, Antonyms\n" +
                         "change of words into different parts of speech, Correspondence : Drafting personal letters, CV, Application for jobs, Business\n" +
                         "letters, Official letters, Project preparation, Report writing, Power-point presentation\n" +
                         "Page 4 of 16\n" +
                         "References:\n" +
                         "1. Essentials of Business Communication, Rajendra Pal & J S Korlahalli\n" +
                         "2. Business Communication, Gyani\n" +
                         "3. Effective Communication, Ludlow and Panthon\n" +
                         "4. A Practical English Grammar, Thomson and Marlinet\n" +
                         "5. English Conversation Practice, Grount Taylor\n" +
                         "6. Developing Communication Skills, Krishna Mohan and Meera Banerji\n" +
                         "7. Business Correspondence and Report Writing, R C Sharma and Krishna Mohan\n" +
                         "8. Communication Skill, R Datta Roy and K K Dhir\n" +
                         "Paper-VI Foundation Course in Science (BCA-106)\n" +
                         "Optics and Lasers 12 Lectures\n" +
                         "Interference of light: Interference in thin films, Newton’s rings Diffraction: Fresnel and Fraunhofer diffraction, Plane diffraction grating,\n" +
                         "Measurement of wave length, Dispersive power of grating, Resolving power, Rayleigh criterion\n" +
                         "Polarization: Double refraction, Nicol’s prism, Quarter wave and half wave plates\n" +
                         "Lasers: Spatial and temporal coherence- coherence length- spontaneous emission- stimulated emission-population inversion- Helium-Neon laser\n" +
                         "Atomic Physics 10 Lectures\n" +
                         "Physical basis of quantum mechanics, Uncertainty principle, Schrodinger’s equation, One and three dimensional potential problems, Particle in a\n" +
                         "box, Tunneling effect, quantum cubic, quantum gate.\n" +
                         "Solid State Physics 8 Lectures\n" +
                         "Bonding in solids, Elastic properties of solids, Defects in crystals, Lattice vibrations and thermal properties of solids, Free electron theory, Band\n" +
                         "theory of solids, Metals, Semiconductors and insulators, Electrical conductivity of simple metals (Free Electron Theory)\n" +
                         "Electrical Measurements and Measuring Instruments 6 Lectures\n" +
                         "Principles of operation and construction of moving coil, Moving iron, Dynamometer and induction types of Ammeters & Voltmeters; Extension\n" +
                         "of their ranges; Measurements of power- Three-ammeters and three voltmeters methods of measuring power in Single phase circuits;\n" +
                         "Construction of Watt meters; Induction and dynamometers types;\n" +
                         "Power supplies 4 Lectures\n" +
                         "Block diagram of Power Supply (PS) and it’s constituent circuits , Electronics voltage stabilizer, Zener and transistor circuits for stabilization,\n" +
                         "Constant current, and current limited PS, Basics of SMPS and UPS.\n" +
                         "References:\n" +
                         "1. Solid State Physics, Charles Kittel\n" +
                         "2. Optics, Ajoy Ghatak\n" +
                         "3. Basic Electrical Engineering: I J Nagrath (TMH)\n" +
                         "4. Electrical Technology: B.L. Theraja (S. Chand)\n" +
                         "5. Integrated Electronics: Jacob Millman\n";
            }
            else if (s2.equals("II"))
            {
                syllabus = "Paper-I Mathematics-II (BCA-201)\n" +
                        "Infinite Series 8 Lectures\n" +
                        "Convergence and divergence of infinite series, Integral test, Comparison test, Ratio test, Cauchy’s root test, Series of positive and\n" +
                        "negative terms, Absolute convergence, Alternating series, Power series and their convergence, Taylor and Maclaurin series\n" +
                        "Complex Variables 8 Lectures\n" +
                        "Complex numbers, Complex plane, Modulus and argument representation of complex numbers, Roots of complex numbers,\n" +
                        "Complex functions and mappings, Complex analytical functions: curves and regions in the complex plane, complex functions, limit,\n" +
                        "derivative, analytic function, Cauchy-Riemann equations, elementary complex functions such as powers, exponential function,\n" +
                        "logarithmic, trigonometric and hyperbolic functions, Inverse functions, Harmonic functions.\n" +
                        "Vector Calculus 8 Lectures\n" +
                        "Scalar and vector fields, Directional derivative & Gradient operator, Conservative fields and potential functions, Divergence and\n" +
                        "Curl of vector fields, Applications to different coordinate systems\n" +
                        "Fourier Series & Fourier Transform 8 Lectures\n" +
                        "Introduction to Fourier Series , Convergence of Fourier Series and their integration and differentiation, Euler formulae for Fourier\n" +
                        "coefficients , Functions having arbitrary period , Even and Odd functions , Half range expansions, Sine , Cosine and Exponential\n" +
                        "Fourier Series, Frequency and Amplitude Spectra of a function ,Fourier integral , Linearity property, Transform of derivatives ,\n" +
                        "Convolution theorem, Fourier Transform Fourier Cosine and Sine Transforms .\n" +
                        "Laplace Transform 8 Lectures\n" +
                        "Definitions, Fundamental Ideas, Operational Properties of the Laplace Transform, Linearity property, Transform of elementary\n" +
                        "functions, Laplace transforms of derivatives and integrals, Differentiation and Integration of transforms, Convolution theorem, \n" +
                        "Page 5 of 16\n" +
                        "Inversion Integral, Use of Laplace transforms in the solution of initial problem, Unit step function, Impulse function-transforms of\n" +
                        "step functions, Transforms of Periodic functions.\n" +
                        "References:\n" +
                        "1. Advanced Engineering Mathematics, Erwin Kreyszig\n" +
                        "2. Higher Engineering Mathematics, B.S. Grewal\n" +
                        "3. Mathematical Methods, Potter and Goldberg\n" +
                        "4. Mathematics for Engineers and Physicists, L.A. Pipes\n" +
                        "5. Applied Mathematics for Mathematician & Engineers: L A Pipes (TMH)\n" +
                        "6. Engineering Mathematics: H K Das (S Chand & Co. Ltd.)\n" +
                        "7. Engineering Mathematics: B.S. Grewal (Khanna Pub.)\n" +
                        "8. Advanced Engineering Mathematics: Wylie C R (TMH)\n" +
                        "9. A Course in Ordinary Differential Equations: Rai, Chaudhary & Friedman\n" +
                        "10. Advance Engineering Mathematics: E. Kreyszig\n" +
                        "Paper-II Business Systems (BCA-202)\n" +
                        "Introduction to Business Data Processing 7 Lectures\n" +
                        "Overview of Business systems; Management Functions, Levels of Management; Sources of Information, Applications like Payroll,\n" +
                        "Accounting, Inventory, MIS, DSS\n" +
                        "Concept of Files 6 Lectures\n" +
                        "File organization and handling: Sequential, Direct and Index Sequential; Usage of Inverted Files, Master & Transaction files, Modes\n" +
                        "of Processing: Batch, Online & Real Time, Report Generation Techniques, Multiple file handling and updation\n" +
                        "Business Applications 7 Lectures\n" +
                        "Design Analysis & Development of Computerized Financial Accounting, Payroll, and Inventory Control etc.\n" +
                        "Introduction to fundamental design activities 10 Lectures\n" +
                        "Information & Information Systems; Types of knowledge; relation between knowledge and information; Characteristics of\n" +
                        "information; Information System Design; Modeling approaches; System development activities; System life cycle; System design\n" +
                        "methodology; Information system analysis approaches; Structured analysis & design\n" +
                        "DFDs, Decision tables and Trees 10 Lectures\n" +
                        "Completeness of decision tables; Resolution of data access conflicts; Software design for maintainability; Decision Table; Object\n" +
                        "oriented analysis & design; Creating systems with acceptable response times, Estimation of design parameters; workload analysis\n" +
                        "of system design specifications; Context diagram and Data Flow Diagram\n" +
                        "References:\n" +
                        "1. Business & Information systems by Nickerson, PHI\n" +
                        "2. Business Data Communication by Stallings, PHI\n" +
                        "3. Business Data Network & Telecommunications, by Panko, PHI\n" +
                        "4. Introduction to FoxPro by R. K. Taxali\n" +
                        "Paper-III Digital Electronics and Computer Organization (BCA-203)\n" +
                        "Introduction 5 Lectures\n" +
                        "Generation of Computers, Functional block diagram of a computer, Hardware and Software, Generation of programming\n" +
                        "languages, CPU, Memory, I/O, Secondary storage, DOS and Windows environment\n" +
                        "Gate 5Lectures\n" +
                        "Level minimization: realization of switching expressions by Karnaugh map and Quinne-Mclusky methods combinational circuits and\n" +
                        "their analysis. Realization of switching expressions by two level AND, OR, invert gates, NAND gates only, NOR gates only and ExOR\n" +
                        "and AND gates only.\n" +
                        "Combinational logic circuits 5 Lectures\n" +
                        "Binary adder and Subtractor circuits, Magnitude comparator, Decoders, Encoders, Multiplexer and demultiplexer, Realization of\n" +
                        "switching expressions by decoders, encoders, multiplexer and Demultiplexer, Programmable logic circuits, Tri-state logic, Memory\n" +
                        "Elements\n" +
                        "Synchronous Sequential Logic Circuits 5 Lectures\n" +
                        "Sequential circuits, latches and Flip Flops, Analysis of clocked sequential circuits. State reduction and assignment, design of\n" +
                        "synchronous circuits, shift registers, ripple counters, synchronous counters.\n" +
                        "Asynchronous Sequential Logic 5 Lectures\n" +
                        "Analysis procedure, circuits with latches, Design procedure, reduction of states and flow tables .Races and race Free State\n" +
                        "assignments, Hazards.\n" +
                        "Digital Integrated Circuits 5 Lectures\n" +
                        "Characteristics of digital ICs. Introduction to logic families- RTL, DTL, TTL, ECL, MOS and CMOS circuits and comparison of their\n" +
                        "performance.\n" +
                        "Page 6 of 16\n" +
                        "Computer Organization 15 Lectures\n" +
                        "Basic building blocks of digital computer- Essential & non-essential components; Types of storage elements- Static memory,\n" +
                        "Dynamic Memory, EDORAM, SDRAM, NVRAM, DDRRAM etc.\n" +
                        "Basic model of stored program computer, Instruction sets: Reduced, Complex. Addressing schemes, Instruction execution\n" +
                        "mechanism, Organization of CPU, Memory organization, RAM, ROM, Cache Memory, Associative memory organization, I/O\n" +
                        "devices with special reference to modern peripheral devices, Data transfer schemes: Hand shaking, Polling, DMA, I/O Processor\n" +
                        "Cache memory & its organization: memory management techniques, Concept of virtual memory\n" +
                        "References:\n" +
                        "1. Digital Design: M.Morris Mano (PHI)\n" +
                        "2. Digital circuits & logic design: S.C.Lee (PHI)\n" +
                        "3. Digital electronics (circuits, systems & ICs): S.N.Ali (Galgotia pub.)\n" +
                        "4. Digital electronics: W.H.Gothmann (PHI)\n" +
                        "5. Switching theory: A.K Gautam (Katsons)\n" +
                        "Paper-IV Data Structures (BCA-204)\n" +
                        "Introduction 10 lectures\n" +
                        "Data Abstraction and Algorithm, Analysis , Data types / objects / structures, Abstract definition of data structures , Representation\n" +
                        "and implementation, Time requirements of algorithms, Space requirements of algorithms.\n" +
                        "Array implementation and addressing with examples Array applications and representation, Polynomials, Sparse matrices, Stringpattern\n" +
                        "Matching\n" +
                        "Linked list 4 Lectures\n" +
                        "Singly linked lists, list heads, circular list, doubly liked lists, orthogonal lists, generalized (recursive) lists, applications.\n" +
                        "Stacks and queues 4 Lectures\n" +
                        "Basic ideas, array and linked representation. Prefix/ infix / postfix expressions and their inter-conversion for evaluation, Priority,\n" +
                        "queues and simulation, Recursion\n" +
                        "Trees 6 Lectures\n" +
                        "Definition, terminologies and properties, Binary tree representation traversals and applications, Threaded binary trees, Binary\n" +
                        "Search trees, AVL Trees\n" +
                        "Graphs 6 Lectures\n" +
                        "Definition, terminologies and properties, Graph representations, Minimum spanning trees, Depth-first search , Breadth-first search ,\n" +
                        "Networks\n" +
                        "Hashing 2 Lectures\n" +
                        "Hash functions, collision resolution techniques (chaining , linear offset, others).\n" +
                        "Dynamic storage management and garbage collection 4 Lectures\n" +
                        "The fragmentation problem, first fit, best fit, next fit boundary tags, buddy system. Garbage collection-free lists, reference counts,\n" +
                        "marking algorithms.\n" +
                        "Sort and search Algorithms 4 Lectures\n" +
                        "Internal and External Sorting algorithms, Heap sort, Merge sort, Quick-sort, General radix sort, Symbol tables, sequential search,\n" +
                        "Binary search, Interpolation search\n" +
                        "References:\n" +
                        "1. Data Structures and Program Design- Robert Kruse.\n" +
                        "2. Data Structures- Horowitz and Sahni\n" +
                        "3. Data Structures through C- A. Tennenbaum\n" +
                        "Paper-V Linux & Shell Programming (BCA-205)\n" +
                        "INTRODUCTION 8 Lectures\n" +
                        "Linux introduction and file system - Basic Features, Advantages, Installing requirement, Basic Architecture of Unix/Linux system,\n" +
                        "Kernel, Shell.\n" +
                        "Linux File system-Boot block, super block, Inode table, data blocks, How Linux access files, storage files, Linux standard\n" +
                        "directories.\n" +
                        "Commands for files and directories cd, ls, cp, md, rm, mkdir, rmdir, pwd, file, more, less, creating and viewing files using cat, file\n" +
                        "comparisons – cmp & comm, View files, disk related commands, checking disk free spaces.\n" +
                        "System startup and shut-down process, init and run levels.\n" +
                        "COMMANDS 8 Lectures\n" +
                        "Page 7 of 16\n" +
                        "Essential linux commands Understanding shells, Processes in linux-process fundamentals, connecting processes with pipes, tee,\n" +
                        "Redirecting input output, manual help, Background processing, managing multiple processes, changing process priority with nice,\n" +
                        "scheduling of processes at command, cron, batch commands, kill, ps, who, sleep, Printing commands, find, sort,\n" +
                        "touch, file, file related commands-ws, sat, cut, dd, etc.\n" +
                        "Mathematical commands- bc, expr, factor, units. Creating and editing files with vi, joe & vim editor\n" +
                        "SHELL PROGRAMMING 16 Lectures\n" +
                        "Shell programming- Basic of shell programming, Various types of shell available in Linux, comparisons between various shells,\n" +
                        "shell programming in bash, read command, conditional and looping statements, case statements, parameter passing and\n" +
                        "arguments, Shell variables, system shell variables, shell keywords, Creating Shell programs for automate system tasks.\n" +
                        "FILTERING 8 Lectures\n" +
                        "Simple filter commands – pr, head, tail, cut, paste, sort, uniq, tr.\n" +
                        "Filter using regular expressions – grep, egrep, and sed.\n" +
                        "awk programming – report printing with awk.\n" +
                        "References:\n" +
                        "1. Linux & Shell Programming,\n" +
                        "2. Beginning Shell Scripting by Erick Foster-Johnson, Wiley India\n" +
                        "3. Beginning Linux Programming, Neil Mathew, Richard Stones, Wiley India\n" +
                        "Paper-VI Principles of Programming Languages (BCA-206)\n" +
                        "Introduction 5 Lectures\n" +
                        "Characteristics of programming Languages, Factors influencing the evolution of programming language, Development in programming\n" +
                        "methodologies, desirable features and design issues.\n" +
                        "Programming Language processors 5 Lectures\n" +
                        "Structures and operations of translators, software simulated computer, syntax, semantics, structure, virtual computers, binding and binding time\n" +
                        "Elementary and structured data type 3 Lectures\n" +
                        "Data object variables, constants, data type, elementary data types, declaration, assignments and initialization, enumeration, characters, strings.\n" +
                        "Structured data type and objects 5 Lectures\n" +
                        "Specification of data structured types, vectors and arrays, records, variable size data structure, pointers and programmer constructed data\n" +
                        "structure, Set files.\n" +
                        "Imperative Languages 5 Lectures\n" +
                        "Block structure, Scope rules, Parameter Passing, Construct like co-routines, Tasks etc.\n" +
                        "Object Oriented languages 5 Lectures\n" +
                        "The class notion- Information hiding and data abstraction using classes, derived classes and inheritance, Polymorphism, Parameterized types.\n" +
                        "Functional languages 6 Lectures\n" +
                        "Functional programming concepts – Referential transparency – Types – Type systems - Names, bindings, environment and scope – Recursive\n" +
                        "functions – Polymorphic functions – Type variables – High order functions – Curried functions – Lists and programming with lists – Definition\n" +
                        "of new user defined types in ML – Abstract data types – Evaluation methods.\n" +
                        "GUI Programming 6 Lectures\n" +
                        "GUI vs CUI; Event Driven Programming; Visual Programming; VB Environment: Steps in creating & using controls; Notion of Scripting;\n" +
                        "Scripting via Perl\n" +
                        "References:\n" +
                        "1. Terrance W Pratt, “Programming Languages: Design and Implementation”, PHI.\n" +
                        "2. Sethi, “Programming Language”, Addison Wesley.\n" +
                        "3. E Horowitz, “Fundamental of Programming Languages”, Galgotia.\n" +
                        "4. Pratt, Zolkowitz, “Programming Languages Design Implementation”, Pearson Edition.\n" +
                        "5. Tucker Noonan, “Programming languages: Principles and Paradigms”, TMH\n" +
                        "6. D. A. Watt, “Programming Languages and Paradigms”, PHI\n" +
                        "7. J. Lloyd, “Foundation of Logic Programming”, Springer verlag\n" +
                        "8. M. Hennessey, “The Semantics of Programming Languages”, John Wiley & Sons\n" +
                        "9. Julia Case Bradley & A.C.Millspaugh “Programming in VB 6.0”\n" +
                        "10. Mark Warhol “The art of programming in Visual Basic”, John Wiley & Sons\n" +
                        "11. C. Reade, “Elements of Functional Programming”, AW\n" +
                        "12. L.C. Paulson, “ML for Working programmer”, Cambridge university press\n" +
                        "13. B. Stroustrup, “The C++ Programming language”, AW ";
            }
            else if (s2.equals("III"))
            {
                syllabus = "Paper-I Discrete Structures and Graph Theory (BCA-301)\n" +
                        "Page 8 of 16\n" +
                        "Mathematical logic 12 Lectures\n" +
                        "Statements, Connectives, Statement formulas, Truth functional rules, Interpretation of formulas, Tautologies, Equivalence,\n" +
                        "Functionally complete set of connectives, Normal forms, Inference, Theory of statement calculus, Consistency of premises,\n" +
                        "Mechanical theorem proving, Predicates, Statement functions, Quantification, Interpretation of predicate formulas, Inference theory\n" +
                        "for predicate calculus, Informal & formal proofs, Prenex normal form\n" +
                        "Set Theory 6 Lectures\n" +
                        "Relations, Relation matrix, Transitive closures, Partitions and equivalence relations, Characteristic functions of a set, Principle of\n" +
                        "inclusion and exclusion, Its applications\n" +
                        "Directed Graphs 10 Lectures\n" +
                        "Definition, Simple digraphs, Matrix representations, Paths, Distances, Connectedness of digraphs, Path and reachability matrices,\n" +
                        "Boolean sum and product of bit matrices, Warshall’s algorithm for transitive closure of relations\n" +
                        "Lattices and Boolean Algebra 12 Lectures\n" +
                        "Partially ordered sets, Hasse diagrams, Lattices, Distributive and Modular lattices, Complements, Boolean Algebra, Atoms and join\n" +
                        "irreducibility, Stone representation theorem, Boolean expressions, Free Boolean Algebra, Boolean functions, Normal forms\n" +
                        "representation and minimization of Boolean functions, Symmetric Boolean functions\n" +
                        "References:\n" +
                        "1. Discrete Mathematical Structures with Application to Computer Science- Tremblay & Manohar\n" +
                        "2. Discrete Mathematical Structures – Preparata and Yeh\n" +
                        "Paper-II Design and Analysis of Algorithms (BCA-302)\n" +
                        "Algorithm Analysis Techniques 10 Lectures\n" +
                        "Recurrences: substitution, iteration and master methods\n" +
                        "Divide-and-conquer: general approach, binary search, merge sort, quick sort, Strassen’s matrix multiplication\n" +
                        "Greedy algorithms: general approach, activity selection, knapsack problem, minimum-spanning tree, Diskstra’s algorithm, Huffman code\n" +
                        "Dynamic Programming 8 Lectures\n" +
                        "General approach, matrix-chain multiplication, all-pairs shortest paths, binary search tree, traveling salesperson, 0/1 knapsack problem\n" +
                        "Backtracking 6 Lectures\n" +
                        "N-queen problem, sum of subsets, knapsack problem, generation of all cliques, traveling salesperson problem, Graph coloring\n" +
                        "Randomizing Algorithms 5 Lectures\n" +
                        "Numerical Integration, Primality testing, randomized min-cut, randomized algorithm for n-queens, quick-sort\n" +
                        "\n" +
                        "Approximation Algorithms 5 Lectures\n" +
                        "Job scheduling, Bin packing, Set cover, Max cut\n" +
                        "Lower Bound Theory 6 Lectures\n" +
                        "Decision tree; Reduction method; Amortized analysis; NP-completeness;\n" +
                        "Approximation algorithms\n" +
                        "References:\n" +
                        "1. Fundamental of Computer algorithms – Horowitz and Sahni\n" +
                        "2. The art of Computer Programming – Donald Knuth\n" +
                        "3. Design Methods and Analysis of Algorithms – S.K. Basu\n" +
                        "4. The Design and Analysis of Computer Algorithms – Aho, Hopcraft and Ullaman\n" +
                        "5. Genetic Algorithm in Search, Optimization and Machine Learning – David E. Goldberg\n" +
                        "6. Algorithm + Data Structure = Programs – N. Wirth\n" +
                        "Paper-III Introduction to System Software (BCA-303)\n" +
                        "Concepts 10 Lectures\n" +
                        "Programming environment; Data declaration; Addressing modes; Branch and loop; Stack & procedure\n" +
                        "Macros and their implementation, Arithmetic & bit operators, Floating point\n" +
                        "Evolution and legacy of x86 processors, Role of OS and the BIOS boot process; Disk storage\n" +
                        "Design of Assembler 15 Lectures\n" +
                        "Assembler; Types of Assemblers; Table processing; Symbol Table\n" +
                        "Loaders & linkers: Types of loaders and linkers; Characteristics of loaders; Loader design options; Overview of linkage editing; Linking for\n" +
                        "overlays; MS-Assembler; The practice of Programming\n" +
                        "Application Programming in C 15 Lectures\n" +
                        "Page 9 of 16\n" +
                        "The UNIX programming environment: System Programming: File System, Procedure, Signals, Directories, Pipes/FIFO, Sockets\n" +
                        "References:\n" +
                        "1. Systems Programming- Donovan\n" +
                        "2. Introduction to Systems Software- Dhamdhere D.M.\n" +
                        "Paper-IV Object Oriented Programming using C++ (BCA 304)\n" +
                        "1. Object Modeling 10 Lectures\n" +
                        "Object & Classes, Links & Associations, Generalization and Inheritance, Aggregation, Abstract Classes, Multiple\n" +
                        "Inheritance, Metadata, Constraints, a sample object model.\n" +
                        "2. Dynamic Modeling 6 Lectures\n" +
                        "Events & States, Operations & methods, State diagrams, concurrency, a sample dynamic model.\n" +
                        "3. Programming in C++ 15 Lectures\n" +
                        "Classes, objects, functions, constructors, destructors, inheritance, polymorphism, virtual functions, class templates,\n" +
                        "Function templates, Working with files.\n" +
                        "4. Object Oriented Testing 5 Lectures\n" +
                        "Difference between structured and OBJECT ORIENTED testing, Test case design model.\n" +
                        "5. OMT Methodologies 4 Lectures\n" +
                        "Comparison of SA/ SD & JSD, Translating OBJECT ORIENTED design into implementation, An example of OBJECT\n" +
                        "ORIENTED design.\n" +
                        "References:\n" +
                        "1. Object-Oriented Modeling and Design:Rumbaugh et al\n" +
                        "2. Object Oriented Design :Booch\n" +
                        "3. Object Oriented Programming in C++ :Lafore\n" +
                        "4. Software Engineering: A practitioner’s Approach Pressman\n" +
                        "Paper V Database Management System (BCA 305)\n" +
                        "Introduction 12 Lectures\n" +
                        "Data, information and knowledge, Characteristics of database approach, Data independence, Architecture of database system,\n" +
                        "Data dictionary, Types of database language, database system life cycle, Overview of hierarchical, network and relational model.\n" +
                        "Relations and Codd’s rules, Concepts of keys, Relation Algebra – Select, Project, Joins, Set operations, Update operations – tuple\n" +
                        "relational calculus, Relational Calculus vs. relational algebra.\n" +
                        "Data definition, data manipulation, view definition, nested queries, updation, Embedded SQL, Handling of nulls and cursors.\n" +
                        "Data Models 8 Lectures\n" +
                        "Conceptual, Logical and Physical design, ER models, ER diagrams, Strong and weak entity sets, Generalization, Specialization\n" +
                        "and Aggregation, Conversion of ER model into relational schemas\n" +
                        "Normalization 10 Lectures\n" +
                        "Normalization concepts, Functional dependencies and dependency preservations, Normal forms – 1NF, 2NF, 3NF, BCNF, 4NF,\n" +
                        "5NF, DKNF, Indexing, File organization, De-normalization, Clustering of tables and indexes.\n" +
                        "Transaction Handling 10 Lectures\n" +
                        "Transaction recovery, System recovery, two phase commit, concurrency problems, locking, deadlocks, security, discretionary and\n" +
                        "mandatory access control, data encryption\n" +
                        "References:\n" +
                        "1. Introduction to Database System – C.J. Date\n" +
                        "2. Database Systems – Mcfadden et.al.\n" +
                        "3. Database Concepts – Navathe et.al.\n" +
                        "4. Database Structured Techniques for Design Performance – S. Atre\n" +
                        "Paper-VI Computer Architecture and Microprocessors (BCA 306)\n" +
                        "Computer Organization 15 Lectures\n" +
                        "Basic building blocks of digital computer- Essential & non-essential components; Types of storage elements- Static memory, Dynamic Memory,\n" +
                        "EDORAM, SDRAM, NVRAM, DDRRAM etc.\n" +
                        "Basic model of stored program computer, Instruction sets: Reduced, Complex. Addressing schemes, Instruction execution mechanism,\n" +
                        "Organization of CPU, Memory organization, RAM, ROM, Cache Memory, Associative memory organization, I/O devices with special reference\n" +
                        "to modern peripheral devices, Data transfer schemes: Hand shaking, Polling, DMA, I/O Processor\n" +
                        "Page 10 of 16\n" +
                        "Cache memory & its organization: memory management techniques, Concept of virtual memory\n" +
                        "Microprocessors and Assembly Language Programming 25 Lectures\n" +
                        "Essential & non-essential components, Detailed study of 8085 and 8086, Addressing modes, Comparative study of 8-bit microprocessors,\n" +
                        "Comparative study of 16-bit microprocessors\n" +
                        "Assembler, Machine language instruction processor, Completeness of instruction set, Assembly language programs for common application\n" +
                        "problems such as Maximum finding, Summation, Sorting, Searching, Multiple precision arithmetic, Delay routines, etc.\n" +
                        "References:\n" +
                        "1. Digital Computer Electronics : Malvino\n" +
                        "2. Microprocessor Architecture Programming Applications with 8085/8080A: Brey\n" +
                        "3. Digital System Design and Microprocessor: Hayes, John P.\n" +
                        "4. Computer Architecture and Organization: Hayes, John P.\n" +
                        "5. Computer System Architecture: Mano, M. M.\n" +
                        "6. Digital Computer Fundamentals: Bartee\n";
            }
            else if (s2.equals("IV"))
            {
                syllabus = "Paper-I Operating System (BCA 401)\n" +
                        "Overview 4 Lectures\n" +
                        "Introduction to OS – its functional behavior and responsibilities, Need for some of monitor/command interpreter, Types of operating systems,\n" +
                        "System structure, Hierarchical and layered organization of OS, Review of I/O and interrupt structure.\n" +
                        "Process Concepts 6 Lectures\n" +
                        "Process definition, Process states and state transitions, Parallel processes and constructs, Process interaction, The determinacy problem, Mutual\n" +
                        "exclusion, Semaphores, Process synchronization, Conditional critical regions and monitors, Inter-process communication, Deadlock problem\n" +
                        "and its solutions.\n" +
                        "Process Management 5 Lectures\n" +
                        "Operating system kernel, Data structures for processes and resources, Context switching, Process control primitives, Process scheduling.\n" +
                        "Memory Management 7 Lectures\n" +
                        "Memory management concepts, Relocation, Linking, Multiprogramming with fixed partitions, Swapping, Variables partitions, Overlays, Virtual\n" +
                        "memory, Segmentation, Paging, Storage allocation strategies, Load control and thrashing\n" +
                        "File and I/O Management 10 Lectures\n" +
                        "Organization of file and I/O subsystems, Directory management, Basic file system, file descriptors, File manipulation, File organization\n" +
                        "methods, Management of auxiliary storage space, Command language and file system utilities, I/O subsystems, Programmed I/O, DMA,\n" +
                        "Interrupt driven I/O, Recovery procedures.\n" +
                        "Protection and Security 8 Lectures\n" +
                        "Safeguards, Penetration, Access and Information flow control, Protection problems, Formal models of protection.\n" +
                        "References:\n" +
                        "1 Introduction to Operating Systems: Deitel\n" +
                        "2 Operating System Concepts: Peterson and Silbershatz\n" +
                        "3 Modern Operating Systems: Andrew S Tanenbaum\n" +
                        "Paper-II Operation Research (BCA 402)\n" +
                        "Network Analysis 6 Lectures\n" +
                        "Terminology of network, Shortest route problem, minimal spanning tree problem, max-flow problem.\n" +
                        "Project Scheduling by PERT/CPM 8 Lectures\n" +
                        "Diagram, representation, critical path calculation, construction of time chart and resource labeling, probability and cost\n" +
                        "consideration in project scheduling, project control.\n" +
                        "Linear Programming 10 Lectures\n" +
                        "Simplex Method, Revised simplex method, Duality in Linear programming, Application of Linear Programming to Economic and\n" +
                        "Industrial Problems.\n" +
                        "Nonlinear Programming 5 Lectures\n" +
                        "The Kuhn-Tucker conditions, Quadratic programming, Convex programming.\n" +
                        "Replacement Models 6 Lectures\n" +
                        "Introduction, Replacement policies for items whose efficiency deteriorates with time, Replacement policies for items that fail\n" +
                        "completely\n" +
                        "Page 11 of 16\n" +
                        "Sequencing Model 5 Lectures\n" +
                        "Classification of self problems, processing of n jobs through two machines, three machines, processing of two jobs through m\n" +
                        "machines\n" +
                        "References:\n" +
                        "1. Operations Research- Taha\n" +
                        "2. Introduction to Operations Research- B.E. Gillet\n" +
                        "3. Optimization Theory and Applications- S.S.Rao\n" +
                        "4. Linear programming- G.Hadley\n" +
                        "Paper III Data Communication & Computer Networks (BCA 403)\n" +
                        "Introduction 12 Lectures\n" +
                        "History of data communication, Open system standard, Definition of communication link and its application in telephony and computer\n" +
                        "networks, Importance of channel bandwidth and system noise, Protocols in telephony and internet communication, Types of channel,\n" +
                        "Advantages and disadvantages of analog and digital transmissions, Digitizing Speech, Wave form coding and companding, Voice over IP\n" +
                        "Data Transmission Basics 8 Lectures\n" +
                        "Synchronous/Asynchronous, Error detection and correction methods, Data compression, Protocol basic, Circuit, Message, Packet and Cell\n" +
                        "switching, Connection oriented and connectionless services, ISO-OSI model, TCP/IP model\n" +
                        "Computer Networks 20 Lectures\n" +
                        "Physical layer communication, Media, Signals and Bits, Time division and frequency division multiplexing, Encoding, Modulation, Delay,\n" +
                        "Bandwidth and noise\n" +
                        "Network and packet communication, Network topology, LAN wired/wireless, Ethernet, CSMA/CD, CSMA/ CA, Token passing rings, FDDI,\n" +
                        "Wireless networks, Network Inter connections with repeaters, Switches, Bridges, Routers and gateways, DSU/CSU, XDSL and cable modems,\n" +
                        "Store and forward, Next-Hop forwarding, Wide Area Network, Router based architecture, Dijkstra’s algorithm\n" +
                        "Internetworking, IP addressing, Address binding with ARP, Datagram encapsulation and fragmentation, Link state and distance vector routing,\n" +
                        "Network properties, Ownership and service paradigm, UDP and TCP, TCP segment format, Adaptive retransmission, ICMP and error handling\n" +
                        "Network applications, Client-Server concepts and application, DNS, HTTP, Email and web browsing, Broadband Multi-Service networks,\n" +
                        "FDDI- II, Cell based networks, ATM LANs, DQDB, ATMR, CRMA-II etc., ISDN\n" +
                        "References:\n" +
                        "1. Computer Networks :Tanenbaum, A.S\n" +
                        "2. Data and Computer communication :Stallings, William\n" +
                        "3. Inter Networking With TCP/IP Vol I, II,III: Comer, D.E. and Stevens D.L.\n" +
                        "4. Computer Network and Distributed Data Processing : Martin.J.\n" +
                        "5. Local Networks : Stalling, William\n" +
                        "6. Data Communication and Networking : Forouzan, B.A\n" +
                        "7. Digital Telephony :Bellamy, John C.\n" +
                        "8. Telephone Electronics : Stephen, Joseph and Steve\n" +
                        "9. Tele Communication Switching Systems and Networks: Viswanathan Thiagrajan\n" +
                        "Paper-IV Software Engineering (BCA 404)\n" +
                        "Evolution & Scope of Software Engineering 4 Lectures\n" +
                        "Introduction to Software Engineering: Software development process; Life Cycle models – Waterfall, Spiral, Evolutionary, Prototype\n" +
                        "Software Production Process 4 Lectures\n" +
                        "Process Models - ; Methodologies; Standards\n" +
                        "Software Project Management 10 Lectures\n" +
                        "4 Ps; Project Planning; Cost estimation – Loc, Function point, COCOMO; Work estimation; Resource estimation; Risk Analysis;\n" +
                        "Project Scheduling; Quality Plans; Project control\n" +
                        "Software Testing 5 Lectures\n" +
                        "Black box vs White Box; Testing in the large vs Testing in the small; System Testing; Debugging; Validation vs Verification\n" +
                        "Software Design 3 Lectures\n" +
                        "Abstraction; Modularity; Cohesion; Coupling\n" +
                        "Software Quality Assurance 5 Lectures\n" +
                        "Quality Models; Software Quality Assurance Activities, Software configuration management; Software Reliability; Introduction to\n" +
                        "SEI-CMM\n" +
                        "Software Maintenance 5 Lectures\n" +
                        "Maintenance concepts and tasks; Side effects; Reverse Engineering; Re-engineering\n" +
                        "Page 12 of 16\n" +
                        "CASE concepts, Use and applications 4 Lectures\n" +
                        "References:\n" +
                        "1. Software Engineering: Ian Sommerville, Pearson Education\n" +
                        "2. Software Engineering: R. S. Pressman, McGraw Hill\n" +
                        "3. An Integrated Approach to Software Engineering: Pankaj Jalote\n" +
                        "Paper-V Web Programming Using JAVA (BCA 405)\n" +
                        "10 Lectures\n" +
                        "1. Programming in Java: Core Java: Introduction, Operator, Data type, Variable, Arrays, Control Statements, Methods &\n" +
                        "Classes, Inheritance, Package and Interface, Exception Handling, Multithread programming, I/O, Java Applet, String\n" +
                        "handling, Networking, Event handling, Introduction to AWT, AWT controls, Layout managers, Menus, Images, Graphics.\n" +
                        "4 Lectures\n" +
                        "2. Communication Issues, the Client, Multi-departmental & Large scale Websites, Quality Assurance and testing,\n" +
                        "Technological advances and Impact on Web Teams.\n" +
                        " 6 Lectures\n" +
                        "3. HTML: Formatting Tags, Links, List, Tables, Frames, forms, Comments in HTML, DHTML.\n" +
                        " 8 Lectures\n" +
                        "4. JavaScript: Introduction, Documents, Documents, forms, Statements, functions, objects in JavaScript, Events and Event\n" +
                        "Handling, Arrays, FORMS, Buttons, Checkboxes, Text fields and Text areas.\n" +
                        " 4 Lectures\n" +
                        "5. XML: Introduction, Displaying an XML Document, Data Interchange with an XML document, Document type definitions,\n" +
                        "Parsers using XML, Client-side usage, Server Side usage.\n" +
                        " 8 Lectures\n" +
                        "6. Common Gateway Interface (CGI), PERL, RMI, COM/DCOM, VBScript, Active Server Pages (ASP).\n" +
                        "Text Book:\n" +
                        " 1. Burdman, “Collaborative Web Development”, Addison Wesley.\n" +
                        " 2. Sharma &Sharma, “Developing E-Commerce Sites”, Addison Wesley\n" +
                        " 3. Ivan Bayross, “Web Technologies Part II”, BPB Publications.\n" +
                        "4. Margaret Levine Young, “The Complete Reference Internet”, TMH\n" +
                        "5. Naughton, Schildt, “The Complete Reference JAVA2”, TMH\n" +
                        "6. Balagurusamy E, “Programming in JAVA”, TMH\n" +
                        "References:\n" +
                        "1. Shishir Gundavarma, “CGI Programming on the World Wide Web”, O’Reilly & Associate.\n" +
                        "2. DON Box, “Essential COM”, Addison Wesley.\n" +
                        "3. Greg Buczek, “ASP Developer’s Guide”, TMH.\n" +
                        "Paper VI Numerical Methods (BCA 406)\n" +
                        "Linear and Non-Linear Equations: 10 Lectures\n" +
                        "Numerical Analysis: Floating point representation of numbers, Errors in numerical computations, sources of errors, significant digits.\n" +
                        "Numerical solution of system of linear equation, LU decomposition, Gauss elimination method, Gauss-Siedel method , Rate of convergence,\n" +
                        "Matrix Inversion\n" +
                        "Roots of Non-linear Algebraic and Transcendental Functions , Bisection, and Newton-Raphson Methods ; Regula Falsi, Secant method; Method\n" +
                        "of iteration , fixed points in iteration.\n" +
                        "Differentiation and Integration: 8 Lectures\n" +
                        "Polynomial interpolation: Finite differences, Newton’s forward and backward differences interpolation polynomials, Numerical differentiation\n" +
                        "and integration, Formulae for derivatives in the case of equally spaced points, Trapezoidal and Simpson rules, Errors of interpolation and\n" +
                        "integration formulae\n" +
                        "Differentials Equations: 8 Lectures\n" +
                        "Numerical solution of ordinary differential equations: Taylor series method, Euler’s method, Modified Euler’s method, Runge-kutta methods,\n" +
                        "Solution of linear difference equations with constant coefficients, Numerical solution of boundary value problems, Methods of finite differences,\n" +
                        "Finite differences methods for solving Laplace’s equation in a rectangular region\n" +
                        "Curve Fitting : 4 Lectures\n" +
                        "Curve fitting, Method of least squares, Correlation and regression, Lines of regression,\n" +
                        "Random numbers: 5 Lectures\n" +
                        "Generation of uniformly distributed random numbers, Linear Congruentional Generators, Normal and exponential distributed numbers, Inverse\n" +
                        "transform method for generating random numbers.\n" +
                        "Monte-Carlo Method: 5 Lectures\n" +
                        "Basic principles, Random sampling, Integration of one dimensional and multi-dimensional integrals by random sampling, Error estimate in\n" +
                        "Monte-Carlo methods, Metropolis Algorithm, simple applications.\n" +
                        "Page 13 of 16\n" +
                        "References:\n" +
                        "1. Numerical Methods for Science and Engg.: Ralph G. Stanton (Prentice-Hall of India)\n" +
                        "2. Elementary Numerical Analysis An algorithmic approach: S.D Conte and Carl de Boor\n" +
                        "References:\n" +
                        "1. Rajaraman V., “Computer Oriented Numerical Methods”, PHI\n" +
                        "2. Gerald & Wheatley, “Applied Numerical Analyses”, AW\n" +
                        "3. Jain, Iyengar and Jain, “Numerical Methods for Scientific and Engineering Computations”, New Age Int.\n" +
                        "4. Grewal B. S., “Numerical methods in Engineering and Science”, Khanna Publishers, Delhi\n" +
                        "5. T. Veerarajan, T Ramachandran, “Theory and Problems in Numerical Methods”, TMH\n" +
                        "6. Pradip Niyogi, “Numerical Analysis and Algorithms”, TMH\n" +
                        "7. Francis Scheld, “Numerical Analysis”, TMH\n";
            }
            else if (s2.equals("V"))
            {
                syllabus = "Paper-I Advance Programming with .Net Framework (BCA 501)\n" +
                        "The .Net Framework 3 Lectures\n" +
                        "Introduction, DLL Hell, CLR, CTS, MSIL\n" +
                        "Basic C# 5 Lectures\n" +
                        "Introduction , Data Types , Identifiers , Arrays , Error Handling\n" +
                        "WinForms Programming 8 Lectures\n" +
                        "Introduction , Window Controls – TextBox , Radio , CheckBox , Combo , PictureBox , Menu , Tab , Progress Bar , ListView ,\n" +
                        "Report Viewer\n" +
                        "OOPS in .Net 8 Lectures\n" +
                        "Base Class Library , Namespace and its importance , System Namespace & Other Important Namespaces , Class / Object ,\n" +
                        "Inheritance , Polymorphism , Abstract Class , Interfaces , Events & Delegates\n" +
                        "Process And Threads 3 Lectures\n" +
                        "Threads , Creation/Stopping Of Threads , Thread Pool Concept , Monitoring a thread , Synchronizing Multiple Threads\n" +
                        "Assemblies & Their Importance 3 Lectures\n" +
                        "Assemblies , Private Assembly , Signing an Assembly , Shared Assemblies, Reflection\n" +
                        "ADO.NET 10 Lectures\n" +
                        "ADO.NET classes hierarchy , Connection , Command , Dataset , Datareader , DataAdapter , SqlDataSource\n" +
                        "References:\n" +
                        "1. C# Black Book by Matt Telles\n" +
                        "2. Complete Reference ASP. Net by MacDonand, TMH\n" +
                        "3. C# Programming Bible by Jeff Ferguson, Brian-Patterson, Wiley\n" +
                        "4. Wrox’s Visual C# 2005 Express Edition, by F. Scott-Barker, Wiley\n" +
                        "Paper-II Embedded Systems (BCA 502)\n" +
                        "Classification of systems 5 Lectures\n" +
                        "Real-time design issues; Typical Real-time applications; Hard vs Soft real-time systems; A reference model for real-time systems;\n" +
                        "Design of data acquisition System; Language issues; Exception handling; Characteristics of real-time OS, Real-time kernels;\n" +
                        "Introduction to iRMX III+, TRON; Inter-task communication & synchronization; Real-time memory management; System\n" +
                        "performance issues & optimization\n" +
                        "Real-time specification & design techniques 4 Lectures\n" +
                        "Mathematical specification; Structure charts; Pseudo-code and programming design languages; DFDs, Petri Nets, State charts,\n" +
                        "Usage of Graphical Techniques\n" +
                        "Commonly used approaches to real-time scheduling 5 Lectures\n" +
                        "Clock driven, priority driven; Priority driven scheduling of periodic tasks, Scheduling a-periodic and sporadic jobs in priority driven\n" +
                        "systems; Resources and resource access control; Multiprocessor scheduling, resource access control & synchronization\n" +
                        "Real-time kernels 5 Lectures\n" +
                        "Polled loop systems; State driven code; Co-routines; Interrupt driven systems- Context Switching, Round Robin systems, Preemptive\n" +
                        "priority systems; Major & Minor processing; Foreground/Background systems; Full featured real-time OS\n" +
                        "Inter-task communication & Synchronization 5 Lectures\n" +
                        "Buffering data- Time-relative buffering, Ring Buffers; Mailboxes & their implementation, Other operation on Mailboxes; Queues;\n" +
                        "Critical regions; Semaphores- Counting Semaphores, Problems with semaphores; Deadlock- Detection & Recover, Avoidance\n" +
                        "Real-Time Memory Management 3 Lectures\n" +
                        "Process Stack Management; Dynamic Allocation; Static schemes\n" +
                        "Page 14 of 16\n" +
                        "System performance analysis & Optimization 5 Lectures\n" +
                        "Response-time calculation; Interrupt Latency; Time loading and its measurement; Reducing response times and time loading;\n" +
                        "Analysis of Memory requirements; Reducing Memory loading\n" +
                        "Comparative study of real-time programming languages 2 Lectures\n" +
                        "Design of Embedded Systems 6 Lectures\n" +
                        "Techniques & issues involved; Architecture for real-time & embedded applications; Interface system for complex industrial\n" +
                        "applications; Mixed analog & Digital Systems; Advanced sampling & Data reconstruction; Fail soft techniques; High integrity\n" +
                        "systems; Standard for safety critical systems\n" +
                        "References:\n" +
                        "1. Automatic Control Systems: Kuo, B.C.\n" +
                        "2. Real-time Computer Control: Linkens & Bennett\n" +
                        "3. Real-time software for small systems: Leigh, A.W.\n" +
                        "4. Programming embedded microprocessors: Fowler, R.J.\n" +
                        "5. Real-time systems Design & Analysis: Laplante P.A.\n" +
                        "Paper-III Computer Graphics (BCA 503)\n" +
                        "Introduction to Computer Graphics 10 Lectures\n" +
                        "Introduction, Graphics display devices, Graphics Input & Output devices, Raster scan graphics, Line and Circle generation\n" +
                        "techniques, Scan conversion, Frame buffer, Filling algorithms.\n" +
                        "Geometrical Transformation 15 Lectures\n" +
                        "Two dimensional transformations, Clipping and windowing methods for 2D images, Three dimensional transformations, Parallel and\n" +
                        "perspective projections, Viewing transformations and viewing systems.\n" +
                        "Curves and Surfaces 15 Lectures\n" +
                        "Parametric and non-parametric curves and their representations, Cubic splines, Bezier and B-splines, Parametric surfaces,\n" +
                        "Surfaces of revolution, Sweep surfaces, Quadric surfaces, Bilinear surfaces, B-spline and Bezier surfaces, Generalized cylinders\n" +
                        "and cones, Polygon mesh and wire-frames.\n" +
                        "References:\n" +
                        "1. Computer Graphics: Principles and Practice: Foley et al.\n" +
                        "2. Computer Graphics: Hern and Baker\n" +
                        "3. Procedural elements in Computer Graphics: David F. Rogers\n" +
                        "4. Computer Graphics: A. Plastock and Gordon Kelley\n" +
                        "5. Computer Graphics for IBM PC: J. Mcgregger and Alan Watt\n" +
                        "6. Mathematical Elements for Computer Graphics: David F. Rogers and J.A.Adams\n" +
                        "7. Speech Analysis, Synthesis & Perception – Flanagan,J.L.\n" +
                        "Paper-IV Secure Computing (BCA 504)\n" +
                        "Introduction 5 Lectures\n" +
                        "History of Computer Crime; Data Communications & information security; Mathematical models of computer security, CIA Triad\n" +
                        "15 Lectures\n" +
                        "Terminology; Mono-alphabetic ciphers; Poly-alphabetic substitution ciphers; Transpositions; Stream & block ciphers; Secure\n" +
                        "encryption systems; Public key encryption systems; RSA encryption; Hash algorithms; Secure secret key systems; DES algorithm;\n" +
                        "8 Lectures\n" +
                        "Information warfare; Viruses & other Malicious code; Mobile code; Denial-of-service attacks; Social Engineering & low-tech attacks;\n" +
                        "Spam, Phishing & Trojans; Web based vulnerabilities; Controls against program threats\n" +
                        "12 Lectures\n" +
                        "Protecting the information infrastructure; Operating system security; Protecting memory & addressing; File protection mechanisms;\n" +
                        "Database security; Security in networks & distributed systems; LAN & Gateway security devices; Intrusion detection & Intrusion\n" +
                        "prevention devices; Identification & authentication; E-commerce & web server safeguards; Web monitoring & content filtering;\n" +
                        "Securing VoIP; Managing software patches & vulnerabilities; Legal & ethical issues in computer security\n" +
                        "References:\n" +
                        "1. Bharat Bhaskar, Electronic Commerce: Framework Technologies and Applications, TMH\n" +
                        "2. Ravi Kalakota & A.B. Whinston, Frontiers of Electronic Commerce, Pearson Education.\n" +
                        "3. Ravi Kalakota & A.B. Whinston, Electronic Commerce – A Manager’s Guide, Pearson Education.\n" +
                        "4. Agarwala Kamlesh, N and Agarwala Deeksha, Business on the Net_Introduction to the E-Com., Macmillan India.\n" +
                        "5. P. T. Joseph, E-Commerce: A Managerial Perspective, PHI, 2002.\n" +
                        "Page 15 of 16\n" +
                        "Paper VI ADVANCED DATABASE MANAGEMENT SYSTEM (BCA-505)\n" +
                        "9 Lectures\n" +
                        "1. Query Processing, Optimization & Database Tuning: Algorithms For Executing Query Operations.Heuristics For Query\n" +
                        "Optimizations, Estimations Of Query Processing Cost, Join Strategies For Parallel Processors, Database Workloads,\n" +
                        "Tuning Decisions, DBMS Benchmarks, Clustering & Indexing, Multiple Attribute Search Keys, Query Evaluation Plans,\n" +
                        "Pipelined Evaluations, System Catalogue In RDBMS.\n" +
                        "9 Lectures\n" +
                        "2. Extended Relational Model & Object Oriented Database System: New Data Types, User Defined Abstract Data Types,\n" +
                        "Structured Types, Object Identity, Containment, Class Hierarchy, Logic Based Data Model, Data Log, Nested Relational\n" +
                        "Model And Expert Database System.\n" +
                        "9 Lectures\n" +
                        "3. Distributed Database System: Structure Of Distributed Database, Data Fragmentation, Data Model, Query Processing,\n" +
                        "Semi Join, Parallel & Pipeline Join, Concurrency Control In Distributed Database System, Recovery In Distributed\n" +
                        "Database System, Distributed Deadlock Detection And Resolution, Commit Protocols.\n" +
                        "9 Lectures\n" +
                        "4. Enhanced Data Model For Advanced Applications: Database Operating System, Introduction To Temporal Database\n" +
                        "Concepts, Spatial And Multimedia Databases, Data Mining, Active Database System, Deductive Databases, Database\n" +
                        "Machines, Web Databases, Advanced Transaction Models, Issues In Real Time Database Design.\n" +
                        "4 Lectures\n" +
                        "5. Introduction To Expert Database And Fuzzy Database System:\n" +
                        "References\n" +
                        "1. Majumdar & Bhattacharya, “Database Management System”, TMH.\n" +
                        "2. Korth, Silbertz, Sudarshan, “ Database Concepts”, McGraw Hill.\n" +
                        "3. Elmasri, Navathe, “Fundamentals Of Database Systems”, Addison Wesley.\n" +
                        "4. Data C J,” An Introduction To Database System”, Addison Wesley.\n" +
                        "5. Ramakrishnan, Gehrke, “Database Management System”, McGraw Hill.\n" +
                        "6. Bernstein, Hadzilacous, Goodman, “ Concurrency Control & Recovery”, Addison Wesley.\n" +
                        "7. Ceri & Palgatti, “Distributed Databases”, McGraw Hill.\n";
            }
            else
            {
                syllabus = "Paper I Image Processing (BCA 601)\n" +
                        "5 Lectures\n" +
                        "1. Introduction: Image representation and modeling, 2-D linear system, Luminance, Contrast and Brightness, Color\n" +
                        "representation, Visibility functions, Monochrome and color vision model.\n" +
                        "10 Lectures\n" +
                        "2. Image Quantization and Image Transforms: Sampling theorem, Anti-aliasing, image quantization, Orthogonal and unitary\n" +
                        "transforms, DFT, Cosine transform, Hadamard transform, Haar transform, KL transform.\n" +
                        "10 Lectures\n" +
                        "3. Image Enhancement: Point operation, Histogram modeling, Filtering and spatial operations, Transform operations, Multispectral\n" +
                        "Image Enhancement\n" +
                        "10 Lectures\n" +
                        "4. Image Restoration: Image formation models, Noise models, Inverse and Wiener filtering, Least square filters, Recursive\n" +
                        "filters, Maximum entropy method, Blind de-convolution, Bayesian method of noise removal, Image reconstruction,\n" +
                        "Tomography, Radan transform, Back-projection, Reconstruction algorithm, Algebraic method of reconstruction, Fanbeam\n" +
                        "reconstruction.\n" +
                        "5 Lectures\n" +
                        "5. Data Compression: Data compression vs. Bandwidth, Pixel coding, Predictive coding, Transform coding, Coding of twotone\n" +
                        "images.\n" +
                        "References:\n" +
                        "1. Fundamentals of Digital Image Processing: Anil K. Jain\n" +
                        "2. Digital Image Processing: R. Chellappa\n" +
                        "3. Image Processing for Scientific Applications: Bernd Jahne\n" +
                        "4. Digital Image Processing: R.C. Gonzalez & R.E. Woods\n" +
                        "5. The Image Processing Handbook: J.C. Russ\n" +
                        "6. Digital Image Processing: W.K. Pratt\n" +
                        "7. Digital Image Restoration: Andrews & Hunt\n" +
                        "Page 16 of 16\n" +
                        "Paper II Multimedia Systems (BCA 602)\n" +
                        "Multimedia Technology 10 Lectures\n" +
                        "Meaning & scope of Multimedia; Elements of Multimedia; Creating multimedia applications; Multimedia file & I/O functions;\n" +
                        "Multimedia data structures; Multimedia file formats; Multimedia Protocols\n" +
                        "Multimedia Audio 12 Lectures\n" +
                        "Digital sound; Audio compression & decompression; Companding; ADPCM compression; MPEG audio compression; True Speech;\n" +
                        "Special effects and Digital Signal Processing; Audio synthesis; FM synthesis; Sound blaster card; Special effect processors on\n" +
                        "sound cards; Wave table synthesis; MIDI functions; Speech synthesis & Recognition\n" +
                        "Multimedia Video 12 Lectures\n" +
                        "Representation of Digital video; Video capture; Frame grabbing; Full motion video; Live video in a window; Video processor; Video\n" +
                        "compression & decompression; Standards for video compression & decompression; Playback acceleration methods; Video\n" +
                        "Conferencing\n" +
                        "Multimedia Authoring Tools 6 Lectures\n" +
                        "Project editor; Topic editor; Hot-spot editor; Developing a multimedia title; Multimedia text authoring systems; Usage of authoring\n" +
                        "tools\n" +
                        "REFERENCES:\n" +
                        "1. Multimedia: Computing, Communications & Applications – Nahrstedt & Steinmetz\n" +
                        "2. Computer Speech Processing – Fallside F.\n" +
                        "3. Speech Analysis, Synthesis & Perception – Flanagan,J.L.\n" +
                        "4. Hypertext & Hypermedia- Nielsen J.";
            }
        }
        else if(s1.equals("PGDCA"))
            {
              if (s2.equals("I")) {
                  syllabus = "SEMESTER I\n" +
                          "PAPER I: Computer Architecture and Organization\n" +
                          "1. Computer Basics: Types of computers, components of a digital computer- CPU, MemoryPrimary\n" +
                          "and Secondary, I/O devices, Types of primary and secondary memories, Cache\n" +
                          "memory, Introduction to MS-Office-MS-word, MS-Excel and MS-PowerPoint.\n" +
                          "2. Number Systems: Binary, Decimal, Octal, Hexadecimal; Inter-conversions; Weighted & unweighted\n" +
                          "codes; Error Correction & detection; Error correcting codes; ASCII & EBCDIC codes.\n" +
                          "3. Boolean Arithmetic & Theorem: Mathematical logic; Truth Tables; Logic variables & logic functions;\n" +
                          "Logic expressions; Equivalent classes of logic functions; Boolean Algebra; Theorems of Boolean Algebra;\n" +
                          "Switching Algebra & functions; Disjunctive & conjunctive canonical forms; Transformations between these\n" +
                          "forms; Simplification of Boolean functions.\n" +
                          "4. Logic gates & families: AND, OR, NOT, NAND, NOR, Ex-OR, Ex-NOR; TTL, ECL, CMOS logic families.\n" +
                          "5. Analysis of combinational logic circuits: Adder, Subtractor, Multiplier, Multiplexer, Demultiplexer,\n" +
                          "Decoder, Encoder, Parity Generator/ Checker, Etc.\n" +
                          "6. Analysis of Sequential logic circuits: Flip-Flops, Registers, Counters, Shift Registers, etc.\n" +
                          "7. Minimization Techniques: Karnaugh Map.\n" +
                          "8. Basic Model of Stored Program Computer: CPU Organization, Memory Organization, memory\n" +
                          "interleaving Cache Memory addressing techniques, I/O methods – direct and indirect, memory\n" +
                          "management techniques, Concept of virtual Memory.\n" +
                          "9. Microprocessors: Essential & Non-essential components; Comparative study of 8-bit microprocessors\n" +
                          "addressing modes, instruction set and its use.\n" +
                          "REFERENCES:\n" +
                          "1. Digital Logic & Computer Design: Mano, M.M.\n" +
                          "2. Computer System Architecture-Mano, M.M.\n" +
                          "3. P.K. Sinha and P. Sinha, “Foundations of Computing”, BPB Publication\n" +
                          "4. ITL Educational Society, “Introduction to IT”, Pearson Education, 2009.\n" +
                          "5. Miller M, “Absolute Beginners Guide to Computer Basics”, Pearson Education, 2009\n" +
                          "6. Mansfield Ron, “Working in Microsoft Office”, 2008, Tata McGraw-Hill\n" +
                          "7. Balagurusamy E, “Fundamentals of Computers”, 2009, Tata McGraw-Hill\n" +
                          "Paper II: Programming Paradigms\n" +
                          "1. Introduction: Characteristics of programming Languages, Factors influencing the evolution of programming\n" +
                          "language, Development in programming methodologies, desirable features and design issues.\n" +
                          "2. Programming Language processors: Structures and operations of translators, software simulated\n" +
                          "computer, syntax, semantics, structure, virtual computers, binding and binding time\n" +
                          "3. Elementary and structured data type: Data object variables, constants, data type, elementary data\n" +
                          "types, declaration, assignments and initialization, enumeration, characters, strings.\n" +
                          "4. Structured data type and objects: Specification of data structured types, vectors and arrays, records,\n" +
                          "variable size data structure, pointers and programmer constructed data structure, Set files.\n" +
                          "5. Imperative Languages: Block structure, Scope rules, Parameter Passing, Construct like co-routines, Tasks\n" +
                          "etc.\n" +
                          "6. Object Oriented languages: The class notion- Information hiding and data abstraction using classes,\n" +
                          "derived classes and inheritance– Polymorphism – Parameterized types.\n" +
                          "7. Functional languages: Functional programming concepts – Referential transparency – Types – Type\n" +
                          "systems - Names, bindings, environment and scope – Recursive functions – Polymorphic functions – Type\n" +
                          "variables – High order functions – Curried functions – Lists and programming with lists – Definition of new\n" +
                          "user defined types in ML – Abstract data types – Evaluation methods.\n" +
                          "8. GUI Programming; GUI vs CUI; Event Driven Programming; Visual Programming; VB Environment: Steps in\n" +
                          "creating & using controls; Notion of Scripting; Scripting via Perl\n" +
                          "Page 2 of 6\n" +
                          "References:\n" +
                          "1. Terrance W Pratt, “Programming Languages: Design and Implementation”, PHI.\n" +
                          "2. Sethi, “Programming Language”, Addison Wesley.\n" +
                          "3. E Horowitz, “Fundamental of Programming Languages”, Galgotia.\n" +
                          "4. Pratt, Zolkowitz, “Programming Languages Design Implementation”, Pearson Edition.\n" +
                          "5. Tucker Noonan, “Programming languages: Principles and Paradigms”, TMH\n" +
                          "6. D. A. Watt, “Programming Languages and Paradigms”, PHI\n" +
                          "7. J. Lloyd, “Foundation of Logic Programming”, Springer verlag\n" +
                          "8. M. Hennessey, “The Semantics of Programming Languages”, John Wiley & Sons\n" +
                          "9. Julia Case Bradley & A.C.Millspaugh “Programming in VB 6.0”\n" +
                          "10. Mark Warhol “The art of programming in Visual Basic”, John Wiley & Sons\n" +
                          "11. C. Reade, “Elements of Functional Programming”, AW\n" +
                          "12. L.C. Paulson, “ML for Working programmer”, Cambridge university press\n" +
                          "13. B. Stroustrup, “The C++ Programming language”, AW\n" +
                          "PAPER III: Programming in ‘C’\n" +
                          "1. Programming in C: History, Introduction to C Programming Languages, Structure of C programs,\n" +
                          "compilation and execution of C programs, Debugging Techniques, Data Types and Sizes, Declaration of\n" +
                          "variables, Modifiers, Identifiers and keywords, Symbolic constants, Storage classes (automatic, external,\n" +
                          "register and static), Enumerations, command line parameters, Macros, The C Preprocessor.\n" +
                          "2. Operators: Unary operators, Arithmetic & logical operators, Bit wise operators, Assignment operators and\n" +
                          "expressions, Conditional expressions, Precedence and order of evaluation.\n" +
                          "3. Control statements: if-else, switch, break, continue, the comma operator, goto statement.\n" +
                          "4. Loops: for, while, do-while.\n" +
                          "5. Functions: built-in and user-defined, function declaration, definition and function call, parameter passing:\n" +
                          "call by value, call by reference, recursive functions, multifile programs.\n" +
                          "6. Arrays: linear arrays, multidimensional arrays, Passing arrays to functions, Arrays and strings.\n" +
                          "7. Structure and Union: definition and differences, self-referential structure.\n" +
                          "8. Pointers: value at (*) and address of (&) operator, pointer to pointer, Dynamic Memory Allocation, calloc\n" +
                          "and malloc functions, array of pointers, function of pointers, structures and pointers.\n" +
                          "9. File Handling in C: opening and closing a data file, creating a data file, read and write functions,\n" +
                          "unformatted data files.\n" +
                          "References:\n" +
                          "1. V. Rajaraman, “Fundamentals of Computers”, PHI\n" +
                          "2. Peter Norton’s, “Introduction to Computers”, TMH\n" +
                          "3. Hahn, “The Internet complete reference”, TMH\n" +
                          "4. Peter Norton’s, “DOS Guide”, Prentice Hall of India\n" +
                          "5. Gottfried, “Programming in C”, Schaum’s Series, Tata McGraw Hill\n" +
                          "6. Kernighan, Ritchie, “The C Programming Language”, PHI\n" +
                          "7. Yashwant Kanitkar, “Working with C”, BPB\n" +
                          "8. Yashwant Kanitkar, “Pointer in C”, BPB\n" +
                          "9. Yashwant Kanitkar, “Let us C”, BPB\n" +
                          "10. Bajpai, Kushwaha, Yadav, “Computers & C Programming”, New Age\n" +
                          "11. E. Balagurusamy, “Programming in ANSI C”, TMH\n" +
                          "PAPER IV: Systems Software\n" +
                          "1. Introduction: Definition and types of operating systems, Batch Systems, multi programming, time–sharing\n" +
                          "parallel, distributed and real-time systems, Operating system structure, Operating system components and\n" +
                          "services, System calls, system programs, Virtual machines\n" +
                          "2. Process Management: Process concept, Process scheduling, Cooperating processes, Threads, Inter-process\n" +
                          "communication, CPU scheduling criteria, Scheduling algorithms, Multiple-processor scheduling, Real-time\n" +
                          "scheduling and Algorithm evaluation; Process Synchronization & Deadlock\n" +
                          "3. Storage management: Memory Management-Logical and Physical Address Space, Swapping, Contiguous\n" +
                          "Allocation, Paging, Segmentation with paging in MULTICS and Intel 386, Virtual Memory, Demand paging\n" +
                          "and its performance, Page replacement algorithms, Allocation of frames, Thrasing, Page Size and other\n" +
                          "considerations, Demand segmentation, File systems, secondary Storage Structure, File concept, access\n" +
                          "methods, directory implementation, Efficiency and performance, recovery, Disk structure, Disk scheduling \n" +
                          "Page 3 of 6\n" +
                          "methods, Disk management, Recovery, Disk structure, disk scheduling methods, Disk management, SwapSpace\n" +
                          "management, Disk reliability.\n" +
                          "4. Security & Case Study: Protection and Security-Goals of protection, Domain of protection; Encryption;\n" +
                          "Windows NT-Design principles, System components, Environmental subsystems, File system, Networking\n" +
                          "and program interface, Linux system-design principles, Kernel Modules, Process Management, Scheduling,\n" +
                          "Memory management, File Systems, Input and Output, Inter-process communication, Network structure,\n" +
                          "security\n" +
                          "5. Linkers and Loaders: Introduction to Assembler, Loaders and Linkers, Interpreters & Compilers;\n" +
                          "Introduction to Assembly Language Programming\n" +
                          "References\n" +
                          "1 Abraham Siberschatz and Peter Baer Galvin, “Operating System Concepts”, Fifth Edition, Addision-Wesley\n" +
                          "2. Milan Milankovic, “Operating Systems, Concepts and Design”, McGraw-Hill.\n" +
                          "3. Harvey M Deital, “Operating Systems”, Addison Wesley\n" +
                          "4. Richard Peterson, “Linux: The Complete Reference”, Osborne McGraw-Hill.\n" +
                          "5. Hopcroft, Sethi and Ullman, Compiler Principles, AddisonWesley\n" +
                          "6. H. Abelson and G. Sussmann, Structure and Interpretation of Computer Programs (SICP), MIT Press\n" +
                          "PAPER V: Database Management System\n" +
                          "1. Introduction: An overview of database management system, Database System Vs File System, Database\n" +
                          "system concepts and architecture, data models schema and instances, data independence and data base\n" +
                          "language and interfaces, Data definitions language, DML, Overall Database Structure.\n" +
                          "2. Data Modeling using the Entity Relationship Model: ER model concepts, notation for ER diagram,\n" +
                          "mapping constraints, keys, Concepts of Super Key, candidate key, primary key, Generalization, aggregation,\n" +
                          "reduction of an ER diagrams to tables, extended ER model, relationships of higher degree.\n" +
                          "3. Relational data Model and Language: Relational data model concepts, integrity constraints: entity\n" +
                          "integrity, referential integrity, Keys constraints, Domain constraints, relational algebra, relational calculus,\n" +
                          "tuple and domain calculus.\n" +
                          "4. Introduction to SQL: Characteristics of SQL, Advantages of SQL, SQL data types and literals, Types of SQL\n" +
                          "commands, SQL operators and their procedure, Tables, views and indexes, Queries and sub queries,\n" +
                          "Aggregate functions, Insert, update and delete operations, Joins, Unions, Intersection, Minus, Cursors in\n" +
                          "SQL. PL/SQL, Triggers and clusters.\n" +
                          "5. Data Base Design & Normalization: Functional dependencies, normal forms, first, second, third normal\n" +
                          "forms, BCNF, inclusion dependencies, loss less join decompositions, normalization using FD, MVD, and JDs,\n" +
                          "alternative approaches to database design.\n" +
                          "6. Transaction Processing Concepts: Transaction system, Testing of serializability, Serializability of\n" +
                          "schedules, conflict & view serializable schedule, recoverability, Recovery from transaction failures, log based\n" +
                          "recovery, checkpoints, deadlock handling.\n" +
                          "7. Concurrency Control Techniques: Concurrency control, locking Techniques for concurrency control, Time\n" +
                          "stamping protocols for concurrency control, validation based protocol, multiple granularity, Multi-version\n" +
                          "schemes, Recovery with concurrent transaction. Transaction Processing in Distributed system, data\n" +
                          "fragmentation. Replication and allocation techniques for distributed system, overview of concurrency control\n" +
                          "and recovery in distrusted database.\n" +
                          "References\n" +
                          "1 Date C J, “An Introduction To Database System”, Addision Wesley\n" +
                          "2 Korth, Silbertz, Sudarshan, “Database Concepts”, McGraw Hill\n" +
                          "3 Elmasri, Navathe, “Fundamentals Of Database Systems”, Addision Wesley\n" +
                          "4 Paul Beynon Davies, “Database Systems”, Palgrave Macmillan\n" +
                          "5 Bipin C. Desai, “An introduction to Database Systems”, Galgotia Publication\n" +
                          "6 Majumdar & Bhattacharya, “Database Management System”, TMH\n" +
                          "7 Ramakrishnan, Gehrke, “Database Management System”, McGraw Hill\n" +
                          "8 Bharti P.K, “An introduction to Database Systems”, JPNP";
            } else if (s2.equals("II")) {
                  syllabus = "PAPER I: Data Structures and Algorithms\n" +
                          "1. Introduction: Algorithms, Analysis of Algorithms, Design of Algorithms, and Complexity of Algorithms,\n" +
                          "Asymptotic Notations, Growth of function,\n" +
                          "2. Arrays: Array Definition, Representation and Analysis, Single and Multidimensional Arrays, address\n" +
                          "calculation, application of arrays, Character String in C, Character string operation, Array as Parameters,\n" +
                          "Ordered List, Sparse Matrices, and Vectors.\n" +
                          "3. Stacks: Array Representation and Implementation of stack, Operations on Stacks: Push & Pop, Array\n" +
                          "Representation of Stack, Linked Representation of Stack, Operations Associated with Stacks, Application of\n" +
                          "stack: Conversion of Infix to Prefix and Postfix Expressions, Evaluation of postfix expression using stack.\n" +
                          "4. Recursion: Recursive definition and processes, example of recursion, Tower of Hanoi Problem, simulating\n" +
                          "recursion. Backtracking, recursive algorithms, principles of recursion, tail recursion, removal of recursion.\n" +
                          "5. Queues: Array and linked representation and implementation of queues, Operations on Queue: Create, Add,\n" +
                          "Delete, Full and Empty. Circular queue, Deque, and Priority Queue.\n" +
                          "6. Linked list: Representation and Implementation of Singly Linked Lists, Two-way Header List, Traversing and\n" +
                          "Searching of Linked List, Overflow and Underflow, Insertion and deletion to/from Linked Lists, Insertion and\n" +
                          "deletion Algorithms, Doubly linked list, Linked List in Array, Polynomial representation and addition,\n" +
                          "Generalized linked list, Garbage Collection and Compaction.\n" +
                          "7. Trees: Basic terminology, Binary Trees, Binary tree representation, algebraic Expressions, Complete Binary\n" +
                          "Tree. Extended Binary Trees, Array and Linked Representation of Binary trees, Traversing Binary trees,\n" +
                          "Threaded Binary trees, Traversing Threaded Binary trees, Huffman algorithm\n" +
                          "8. Searching and Hashing: Sequential search, binary search, comparison and analysis, Hash Table, Hash\n" +
                          "Functions, Collision Resolution Strategies, Hash Table Implementation.\n" +
                          "9. Sorting: Insertion Sort, Bubble Sorting, Quick Sort, Two Way Merge Sort, Heap Sort, Sorting on Different\n" +
                          "Keys, Practical consideration for Internal Sorting.\n" +
                          "10. Binary Search Trees: Binary Search Tree (BST), Insertion and Deletion in BST\n" +
                          "11. File Structures: Physical Storage Media File Organization, Organization of records into Blocks, Sequential\n" +
                          "Files, Indexing and Hashing, Primary indices, Secondary indices, B+ Tree index Files, B Tree index Files,\n" +
                          "Indexing and Hashing Comparisons\n" +
                          "References\n" +
                          "1. Horowitz and Sahani, “Fundamentals of data Structures”, Galgotia\n" +
                          "2. R. Kruse etal, “Data Structures and Program Design in C” Pearson Education\n" +
                          "3. A M Tenenbaum etal, “Data Structures using C & C++”, PHI\n" +
                          "4. Lipschutz, “Data Structure”, TMH\n" +
                          "5. K Loudon, “Mastering Algorithms With C”, Shroff Publisher & Distributors\n" +
                          "6. Bruno R Preiss, “Data Structures and Algorithms with Object Oriented Design Pattern in C++”, Jhon Wiley & Sons,\n" +
                          "Inc.\n" +
                          "7. Adam Drozdek, “Data Structures and Algorithms in C++”, Thomson Asia\n" +
                          "8. Pal G. Sorenson, “An Introduction to Data Structures with Application”, TMH.\n" +
                          "9. Horowitz Sahani, “Fundamentals of Computer Algorithms”, Golgotia\n" +
                          "10. Brassard Bratley, “Fundamental of Algorithms”, PHI\n" +
                          "11. M T Goodrich etal, “Algorithms Design”, John Wiley\n" +
                          "12. A V Aho etal, “The Design and analysis of Algorithms”, Pearson Education\n" +
                          "Paper II: System Analysis and Design\n" +
                          "1. System Concepts and Information Systems Environment: The System Concept: Definition,\n" +
                          "Characteristics of Systems, Elements of a System, Open and Closed System, Formal and Informal\n" +
                          "Information Systems, Computer based Information Systems, Management Information System, Decision\n" +
                          "Support System, General Business Knowledge, and Interpersonal Communicational System.\n" +
                          "2. The System Development Life Cycle: Recognition of needs, Impetus for System Change, Feasibility\n" +
                          "Study, Analysis, Design, Implementation, Post implementation & Maintenance.\n" +
                          "3. The Role of the Systems Analyst: Historical Perspective, The War Effort, What Dues it take to do System\n" +
                          "Analysis, Academic & Personal Qualifications, The Multifaceted role of the Analyst, The Analyst/User \n" +
                          "Page 5 of 6\n" +
                          "Interface, Behavioral issues.\n" +
                          "4. Systems Planning & Initial Investigation: Strategies for Determining Information Requirement, Problem\n" +
                          "Definition & Project initiation, Background Analysis, Fact Analysis, Review of Written Documents, Onsite\n" +
                          "Observations, Interviews & Questionnaires, Fact Analysis, Performance Analysis, Efficiency Analysis, Service\n" +
                          "Analysis.\n" +
                          "5. Information Gathering: What Kind of Information do we need? Information about the firms, Information\n" +
                          "gathering tools, The art of Interviewing, Arranging the Interview, Guides to a Successful Interview, Types of\n" +
                          "Interviews and Questionnaires, The Structured and Unstructured Alternatives.\n" +
                          "6. The Tools of Structured Analysis: The Dataflow Diagram (DFD), Data Dictionary, Decision Trees and\n" +
                          "Structured English.\n" +
                          "7. Feasibility Study: System performance, Economic Feasibility, Technical Feasibility, Behavioral Feasibility,\n" +
                          "Steps in Feasibility Analysis.\n" +
                          "8. Input/Output and Forms Design: Input Design, CRT Screen Design, Output Design, Requirements of form\n" +
                          "Design.\n" +
                          "9. H/W / S/W Selection and Maintenance: The Computer Industry, S/W Industry, a Procedure for H/W /\n" +
                          "S/W Selection, Major Phases in Selection, Criteria for S/W Selection, The Used Computer, The Computer\n" +
                          "Contract.\n" +
                          "References\n" +
                          "1. Elias M.Awad, “Systems Analysis & Design”, Galgotia Publication.\n" +
                          "2. Hoffer, “Modern Systems Analysis & Design”, Addision Wesley.\n" +
                          "3. Kendall, “Introduction to System Analysis & Design”, McGraw Hill.\n" +
                          "PAPER III: Data Communication & Networks\n" +
                          "1. Data Communication Basics: History of Data Communication; Open System Standard; The electrical\n" +
                          "interface-transmission media, attenuation and distortion sources, signal types and signal propagation delay,\n" +
                          "public carrier service, physical layer interface standard; Computer networks: Circuit, Message, Packet & Cell\n" +
                          "switching, Connection oriented and connectionless services\n" +
                          "2. Data Transmission basics: Synchronous/asynchronous transmission; error detection method; data\n" +
                          "compression; transmission control circuits; communication control devices; protocol basics; data link control\n" +
                          "protocol\n" +
                          "3. Computer Networks: LAN-wired/wireless, protocols, Ethernet switching; fast Ethernet; FDDI; Bridges\n" +
                          "4. Wide Area Network: Characteristic of public data networks; packet switched; circuit switched; ISDN;\n" +
                          "private networks\n" +
                          "5. Internetworking: inter network architecture issues, IP standards, ISO routing protocols\n" +
                          "6. Broad band multi service networks: networking requirement, FDDI II, Cell based networks, ATM LANs\n" +
                          "7. Transport Protocols: Application support protocols, Application specific protocols\n" +
                          "8. System aspects: Layer interactions, implementation issues, related standards; Voice over IP\n" +
                          "References:\n" +
                          "1. Data and Computer Communication- W.Stallings,\n" +
                          "2. Computer Networks- A.S.Tanenbaum\n" +
                          "3. Computer Network and Distributed Data Processing- J. Martin\n" +
                          "4. Local Networks - W.Stallings\n" +
                          "5. Computer Communication Network Design and Analysis- M.Schwertz\n" +
                          "6. Data Communications and Networking- B. A. Forouzan\n" +
                          "7. Internetworking with TCP/IP -Vol I,II & III – Comer, D.E. & Stevens D.L.\n" +
                          "PAPER IV: Object Oriented Programming in ‘C++’\n" +
                          "1. Object Modeling: Object & classes, Links and Associations, Generalization and Inheritance, Aggregation,\n" +
                          "Abstract classes, A sample object model, Multiple Inheritance, Meta data, candidate keys, constraints.\n" +
                          "2. Dynamic Modeling: Events and States, Operations and Methods, Nested state Diagrams, Concurrency,\n" +
                          "Relation of Object and Dynamic Models, advanced dynamic model concepts, a sample dynamic model.\n" +
                          "3. Functional Modeling: Functional Models, Data flow Diagrams, Specifying Operations, Constraints, a sample \n" +
                          "Page 6 of 6\n" +
                          "functional model.\n" +
                          "4. Programming in C++: Classes and objects in C++, Functions, Constructors, Destructors, Inheritance,\n" +
                          "Functions overloading, Operator Overloading, I/O Operations.\n" +
                          "Real life applications, Extended Classes, Pointer, Virtual functions, Polymorphisms, Working with files, Class\n" +
                          "templates, Function templates.\n" +
                          "5. Translating object oriented design into an implementation, OMT Methodologies, examples and case studies to\n" +
                          "demonstrate methodology, comparison of Methodology, SA/SD, and JSD.\n" +
                          "References\n" +
                          " 1. Rambaugh James etal, “Object Oriented Design and Modeling”, PHI-1997\n" +
                          " 2. Bjarne Stroustrup, “C++ Programming Language”, Addison Wesley\n" +
                          " 3. Balagurusamy E, “Object Oriented Programming with C++”, TMH, 2001\n" +
                          " 4. Booch Grady, “Object Oriented Analysis and Design with application 3/e”, Pearson\n" +
                          " 5. Lipman, Stanley B, Jonsce Lajole, “ C++ Primer Reading”, AWL, 1999\n" +
                          " 6. Dillon and Lee, “Object Oriented Conceptual Modeling”, New Delhi PHI-1993\n" +
                          " 7. Stephen R. Shah, “Introduction to Object Oriented Analysis and Design”, TMH\n" +
                          " 8. Berzin Joseph, “Data Abstraction: the object oriented approach using C++”, McGraw Hill\n" +
                          " 9. Mercer, “Computing Fundamental with C++”, Palgrave Macmillan\n" +
                          "PAPER V: Internet & Java Programming\n" +
                          "1. Internet: Internet, Connecting to Internet: Telephone, Cable, Satellite connection, Choosing an ISP,\n" +
                          "Introduction to Internet services, E-Mail concepts, Sending and Receiving secure E-Mail, Voice and Video\n" +
                          "Conferencing.\n" +
                          "2. Core Java: Introduction, Operator, Data type, Variable, Arrays, Control Statements, Methods & Classes,\n" +
                          "Inheritance, Package and Interface, Exception Handling, Multithread programming, I/O, Java Applet, String\n" +
                          "handling, Networking, Event handling, Introduction to AWT, AWT controls, Layout managers, Menus, Images,\n" +
                          "Graphics.\n" +
                          "3. Java Swing: Creating a Swing Applet and Application, Programming using Panes, Pluggable Look and feel,\n" +
                          "Labels, Text fields, Buttons, Toggle buttons, Checkboxes, Radio Buttons, View ports, Scroll Panes, Scroll\n" +
                          "Bars, Lists, Combo box, Progress Bar, Menus and Toolbars, Layered Panes, Tabbed Panes, Split Panes,\n" +
                          "Layouts, Windows, Dialog Boxes, Inner frame.\n" +
                          "4. JDBC: The connectivity Model, JDBC/ODBC Bridge, java.sql package, connectivity to remote database,\n" +
                          "navigating through multiple rows retrieved from a database.\n" +
                          "5. Java Beans: Application Builder tools, The bean developer kit(BDK), JAR files, Introspection, Developing a\n" +
                          "simple bean, using Bound properties, The Java Beans API, Session Beans, Entity Beans, Introduction to\n" +
                          "Enterprise Java beans (EJB), Introduction to RMI (Remote Method Invocation): A simple client-server\n" +
                          "application using RMI.\n" +
                          "6. Java Servlets: Servlet basics, Servlet API basic, Life cycle of a Servlet, Running Servlet, Debugging\n" +
                          "Servlets, Thread-safe Servlets, HTTP Redirects, Cookies, Introduction to Java Server pages (JSP).\n" +
                          "References:\n" +
                          "1. Margaret Levine Young, “The Complete Reference Internet”, TMH\n" +
                          "2. Naughton, Schildt, “The Complete Reference JAVA2”, TMH\n" +
                          "3. Balagurusamy E, “Programming in JAVA”, TMH\n" +
                          "4. Dustin R. Callway, “Inside Servlets”, Addison Wesley\n" +
                          "5. Mark Wutica, “Java Enterprise Edition”, QUE\n" +
                          "6. Steven Holzner, “Java2 Black book”, dreamtech";
            }
            else{
                  syllabus = "You enter a wrong choise";
                }
        }
    }
    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                getSyllabus();
                AlertDialog alertDialog = new AlertDialog.Builder(
                        Syllabus.this).create();

                // Setting Dialog Title
                alertDialog.setTitle("Syllabus");

                // Setting Dialog Message
                alertDialog.setMessage(syllabus);

                // Setting Icon to Dialog
                alertDialog.setIcon(R.drawable.tick);

                // Setting OK Button
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        }
                });

                alertDialog.show();
            }
        });
    }
}