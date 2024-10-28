package com.example.ud04_1_inbox

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    // recuperamos la toolbar creada en activitymain y la asociamos a una constante
     val tool = findViewById<MaterialToolbar>(R.id.toolbar)
    // le decimos que es la toolbar por defecto
     setSupportActionBar(tool)

    // recuperar el drawer layout

    val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

     //controlador de navegación
     val navHostFragment = supportFragmentManager.findFragmentById(R.id.container_fragment) as NavHostFragment
     val navController = navHostFragment.navController
     val appBarConfig = AppBarConfiguration.Builder(navController.graph)

        //indico que hay un elemento openable
        appBarConfig.setOpenableLayout(drawerLayout)
        val appBarBuilder= appBarConfig.build()


        //toolbar con controller
         tool.setupWithNavController(navController, appBarBuilder)

        // para hacer la barra bottom navegable, recuperamos la vista especifica y le asignamos el controlador
        val bottombar = findViewById<BottomNavigationView>(R.id.bottomBar)
        bottombar.setupWithNavController(navController)

        // para hacer la barra lateral navegable, recuperamos la vista especifica y le asignamos el controlador
        val navSide = findViewById<NavigationView>(R.id.nav_side)
        navSide.setupWithNavController(navController)

    }


    //dice cuando una de las opciones es seleccionada, qué vas a hacer
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.container_fragment)
        NavigationUI.onNavDestinationSelected(item, navController)
        return super.onOptionsItemSelected(item)
    }

    //este método se ejecuta cuando se pinta la toolbar por defecto
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar,menu)
        return super.onCreateOptionsMenu(menu)
    }

}