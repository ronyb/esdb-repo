import { Component, OnInit } from '@angular/core';
import { ISkill } from './skill';

@Component({
    selector: 'app-skills',
    templateUrl: './skills-list.component.html',
    styleUrls: ['./skills-list.component.css']
})
export class SkillsListComponent implements OnInit {

    pageTitle: string = 'Skills List';
    imageWidth: number = 50;
    imageMargin: number = 2;
    
    skills: ISkill[] = [
        {
            "id": 1,
            "skillName": "Java",
            "skillDescription": "Java is a general-purpose computer-programming language that is concurrent, class-based, object-oriented, and specifically designed to have as few implementation dependencies as possible. It is intended to let application developers \"write once, run anywhere\" (WORA), meaning that compiled Java code can run on all platforms that support Java without the need for recompilation. Java applications are typically compiled to bytecode that can run on any Java virtual machine (JVM) regardless of computer architecture. As of 2016, Java is one of the most popular programming languages in use, particularly for client-server web applications, with a reported 9 million developers. Java was originally developed by James Gosling at Sun Microsystems (which has since been acquired by Oracle Corporation) and released in 1995 as a core component of Sun Microsystems' Java platform. The language derives much of its syntax from C and C++, but it has fewer low-level facilities than either of them.",
            "category": "Programming languages",
            "subcategory": "General-purpose programming languages",
            "learningResourcesJson": null,
            "topqRelevance": 5,
            "creationDate": "2018-04-01T11:10:24.000+0000",
            "updateDate": "2018-04-01T11:21:19.000+0000",
            "logoImageUrl": "http://localhost:8080/skill-logos/java.png"
        },
        {
            "id": 2,
            "skillName": "C#",
            "skillDescription": "C# is a multi-paradigm programming language encompassing strong typing, imperative, declarative, functional, generic, object-oriented (class-based), and component-oriented programming disciplines. It was developed by Microsoft within its .NET initiative and later approved as a standard by Ecma (ECMA-334) and ISO (ISO/IEC 23270:2006). C# is one of the programming languages designed for the Common Language Infrastructure.",
            "category": "Programming languages",
            "subcategory": "General-purpose programming languages",
            "learningResourcesJson": null,
            "topqRelevance": 0,
            "creationDate": "2018-04-01T13:23:28.000+0000",
            "updateDate": "2018-04-01T13:23:28.000+0000",
            "logoImageUrl": "http://localhost:8080/skill-logos/csharp.png"
        },
        {
            "id": 3,
            "skillName": "Python",
            "skillDescription": "Python is an interpreted high-level programming language for general-purpose programming. Created by Guido van Rossum and first released in 1991, Python has a design philosophy that emphasizes code readability, notably using significant whitespace. It provides constructs that enable clear programming on both small and large scales.\r\nPython features a dynamic type system and automatic memory management. It supports multiple programming paradigms, including object-oriented, imperative, functional and procedural, and has a large and comprehensive standard library.",
            "category": "Programming Languages",
            "subcategory": "",
            "learningResourcesJson": null,
            "topqRelevance": 4,
            "creationDate": "2018-04-01T13:54:45.000+0000",
            "updateDate": "2018-04-01T13:54:45.000+0000",
            "logoImageUrl": "http://localhost:8080/skill-logos/python.png"
        }
    ];
    
    constructor() {
        console.log("skills-list.component.constructor");
    }

    ngOnInit(): void {
        console.log("skills-list.component.ngOnInit");
    }
}