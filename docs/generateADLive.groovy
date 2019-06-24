@Grapes([
        @Grab(group='org.asciidoctor', module='asciidoctorj',   version='1.5.6'   ),
        @Grab(group='org.jruby',       module='jruby-complete', version='9.1.15.0')
])

import org.asciidoctor.SafeMode
import org.asciidoctor.OptionsBuilder
import org.asciidoctor.Asciidoctor.Factory


void createSlides(){
    asciidoctor = Factory.create()
    options = OptionsBuilder.options().
            templateDirs(new File('./asciidoctor-reveal.js/','templates')).
            backend('revealjs').
            inPlace(true).
            safe(SafeMode.UNSAFE).
            get()

    asciidoctor.convertFile(new File("doc.adoc"), options)
}


void dumpRevealJS(){
    ["git", "clone", "https://github.com/hakimel/reveal.js.git"].execute()
    ["git", "clone", "https://github.com/asciidoctor/asciidoctor-reveal.js.git"].execute()
}


dumpRevealJS()
createSlides()
println "Creado!!!"