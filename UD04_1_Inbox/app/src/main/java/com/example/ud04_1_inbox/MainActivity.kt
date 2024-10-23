package com.example.ud04_1_inbox

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

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

     //controlador de navegación
     val navHostFragment = supportFragmentManager.findFragmentById(R.id.container_fragment) as NavHostFragment
     val navController = navHostFragment.navController
     val appBarConfiguration = AppBarConfiguration.Builder(navController.graph).build()

      tool.setupWithNavController(navController, appBarConfiguration)

        // para la barra de navegacion bottom
        val bottombar = findViewById<BottomNavigationView>(R.id.bottomBar)
        bottombar.setupWithNavController(navController)

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