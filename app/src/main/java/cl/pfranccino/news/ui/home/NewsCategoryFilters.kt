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
import androidx.compose.material3.MaterialTheme
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
    categories: List<String>,
    onCategorySelected: (String?) -> Unit
) {
    var selectedCategory by remember { mutableStateOf<String?>(null) }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(categories) { category ->
            FilterChip(
                onClick = {
                    selectedCategory = if (selectedCategory == category) {
                        null
                    } else {
                        category
                    }
                    onCategorySelected(selectedCategory)
                },
                label = {
                    Text(
                        text = category.replaceFirstChar { it.uppercase() },
                        style = NewsTextStyles.categoryChip
                    )
                },
                selected = selectedCategory == category,
                leadingIcon = if (selectedCategory == category) {
                    {
                        Icon(
                            imageVector = Icons.Filled.Done,
                            contentDescription = "Selected",
                            modifier = Modifier.size(FilterChipDefaults.IconSize)
                        )
                    }
                } else {
                    null
                },
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                    selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    selectedLeadingIconColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                border = FilterChipDefaults.filterChipBorder(
                    borderColor = MaterialTheme.colorScheme.outline,
                    selectedBorderColor = MaterialTheme.colorScheme.primary,
                    disabledBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.12f),
                    disabledSelectedBorderColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.12f),
                    borderWidth = 1.dp,
                    selectedBorderWidth = 2.dp,
                    enabled = selectedCategory == category,
                    selected = selectedCategory != null && selectedCategory != category
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsCategoryFiltersPreview() {
    NewsTheme {
        val categories =
            listOf("business", "entertainment", "general", "health", "science", "sports", "technology")
        NewsCategoryFilters( categories =categories , onCategorySelected = {})
    }
}