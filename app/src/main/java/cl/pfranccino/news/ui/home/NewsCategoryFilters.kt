package cl.pfranccino.news.ui.home

import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cl.pfranccino.news.ui.theme.NewsTextStyles
import cl.pfranccino.news.ui.theme.NewsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsCategoryFilters(
    onCategorySelected: (Set<String>) -> Unit,
    modifier: Modifier = Modifier
) {
    val categories =
        listOf("business", "entertainment", "general", "health", "science", "sports", "technology")
    var selectedCategories by remember { mutableStateOf(emptySet<String>()) }

    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {

        items(categories) { category ->
            val selected = selectedCategories.contains(category)
            FilterChip(
                onClick = {
                    selectedCategories = if (selected) {
                        selectedCategories - category
                    } else {
                        selectedCategories + category
                    }
                    onCategorySelected(selectedCategories)
                },
                label = {
                    Text(text = category.replaceFirstChar { it.uppercase() } , style = NewsTextStyles.categoryChip)
                },
                selected = selected,
                leadingIcon = if (selected) {
                    {
                        Icon(
                            imageVector = Icons.Filled.Done,
                            contentDescription = "Selected",
                            modifier = Modifier.size(FilterChipDefaults.IconSize)
                        )
                    }
                } else {
                    null
                })
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NewsCategoryFiltersPreview() {
    NewsTheme {
        NewsCategoryFilters(onCategorySelected = {})
    }
}